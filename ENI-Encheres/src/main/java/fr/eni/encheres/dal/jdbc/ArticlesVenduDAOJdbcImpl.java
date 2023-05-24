package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.dal.connection.ConnectionProvider;
import fr.eni.encheres.dal.interfaces.ArticlesVenduDAO;
import fr.eni.encheres.exceptions.DALException;
import fr.eni.encheres.bo.Categories;


/*
 * - gerer update
 * - gerer insert apres connexion utilisateur faite !(Urgent)
 * */

public class ArticlesVenduDAOJdbcImpl implements ArticlesVenduDAO{
	// \n\r pour les saut de lignes et bonne execution des requetes
	
	//version final avec utilisateurs
//	public final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom, description,date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, r\n)"
//			+ "date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image) \r\n"
//			+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
	//version test
	public final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom, description,date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, r\n)"
			+ "date_fin_enchere, prix_initial, prix_vente,etat_vente, image) \r\n"
			+ " VALUES (?,?,?,?,?,?,?,?)";
	
	
	//avec l'utilisateurs
	/*private static final String SELECT_ALL ="select av.no_article, nom_article, av.[description], date_debut_encheres, date_fin_encheres,\n"
			+ "prix_initial, prix_vente, u.*, c.*\n"
			+ "from ARTICLES_VENDUS av \n"
			+ "inner join UTILISATEURS u on u.no_utilisateur = av.no_utilisateur\n"
			+ "inner join CATEGORIES c on c.no_categorie = av.no_categorie";*/ 
	
	//sans l'utiliosateurs
	private static final String SELECT_ALL ="select av.no_article, nom_article, av.[description], date_debut_encheres, date_fin_encheres,\n"
			+ "prix_initial, prix_vente, c.*\n"
			+ "from ARTICLES_VENDUS av \n"
			+ "inner join CATEGORIES c on c.no_categorie = av.no_categorie"; 
	
	
	
	public final String DELETE = "Delete from ARTICLES_VENDUS where no_article = ?";
	
	@Override
	public void insertArticle(ArticlesVendu articleVendu) throws DALException {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionProvider.connection()){
			PreparedStatement pStmt = con.prepareStatement(INSERT_ARTICLE);
			pStmt.setString(1, articleVendu.getArticleName());
			pStmt.setString(2, articleVendu.getDescription());
			pStmt.setDate(3,java.sql.Date.valueOf(articleVendu.getDateStartEnchere()));
			pStmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDateEndEnchere()));
			pStmt.setInt(5, articleVendu.getPrixInitial());
			pStmt.setInt(6, articleVendu.getPrixVente());
			/*Ajouts des différentes methodes  getUtilisateur et gestion des dates*/
			//pStmt.setInt(7, articleVendu.getUtilisateur.getId());
			//pStmt.setString(8, articleVendu.getCategories.getNo_utilisateur());
			pStmt.setString(7, articleVendu.getEtat_vente());

			pStmt.executeUpdate();
			
		} catch(SQLException e) {
		throw new DALException("Impossible d'insérer l'article", e);
		}
	}


	@Override
	public void Update(ArticlesVendu articleVendu) throws DALException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ArticlesVendu> SelectAll() throws DALException {
		// TODO Auto-generated method stub
		//initilisation d'une liste d'article
		List<ArticlesVendu> ListArticlesVendu = new ArrayList<ArticlesVendu>();
		
		
		
				
				
				// ouvre une connexion à la base de donnée
				try (Connection con = ConnectionProvider.connection()){
					//On charge  et prépare la requête pour exécution
					PreparedStatement pst = con.prepareStatement(SELECT_ALL);
					//on execute la requete et récupère les élement qu'lle nou retourne 
					ResultSet rs = pst.executeQuery();	
					
					/*
					 * Pour chaque ligne de la liste retouné 
					 * on crée un objet de type utilisateur qu'on va associé à chaque colonne de notre ligne 
					 * puis on va ajouter l'ojet region à notre liste d'utilisateurs
					 */
					while (rs.next()) {
						//initialisation d'un objet Article_Vendus
						ArticlesVendu ArticleVendu = new ArticlesVendu();
						ArticleVendu.setNo_article(rs.getInt("no_article"));
						ArticleVendu.setArticleName(rs.getString("nom_article"));
						ArticleVendu.setDescription(rs.getString("description"));
						ArticleVendu.setDateStartEnchere(rs.getDate("date_debut_encheres").toLocalDate());
						ArticleVendu.setDateEndEnchere(rs.getDate("date_fin_encheres").toLocalDate());
						ArticleVendu.setPrixInitial(rs.getInt("prix_initial"));
						ArticleVendu.setPrixVente(rs.getInt("prix_vente"));
						
						//pour retourner le Utilisateur correspondants
						
						/*Utilisateurs u = new Utilisateurs();
						u.setNo_utilisateur(rs.getInt("no_utilisateur"));
						u.setNom(rs.getString("nom"));
						u.setPrenom(rs.getString("prenom"));
						u.setPseudo(rs.getString("pseudo"));
						u.setEmail(rs.getString("email"));
						u.setTelephone(rs.getString("telephone"));
						u.setRue(rs.getString("rue"));
						u.setCode_postale(rs.getString("code_postal"));
						u.setVille(rs.getString("ville"));
						u.setMot_de_passe(rs.getString("mot_de_passe"));
						u.setCredit(rs.getInt("credit"));
						u.setAministrateur(rs.getBoolean("administrateur"));*/
						
						/*vArticleVendu.setUtilisateur(u);*/
						Categories c = new Categories();
						c.setId(rs.getInt("no_categorie"));
						c.setName(rs.getString("libelle"));
						
						ArticleVendu.setCategorie(c);
						/*vArticleVendu.setEtat_vente(rs.getString("etat_vente"));*/
						ListArticlesVendu.add(ArticleVendu);
					}
					
					//on retourne la liste d'utilisateur
					return ListArticlesVendu ;
				} 
				catch (SQLException e) {
					
					//Message d'erreur 
					throw new DALException("Fonction SelectALL ArticlesVendusJDBCImpl " + e.getMessage());
				}
		
		/*return ListArticlesVendu ;*/
		
	}


	@Override
	public void Delete(int no_article) throws DALException {
		// TODO Auto-generated method stub
		
	}
}
