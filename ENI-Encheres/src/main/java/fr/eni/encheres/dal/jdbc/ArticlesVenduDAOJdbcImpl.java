package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.dal.connection.ConnectionProvider;
import fr.eni.encheres.dal.interfaces.ArticlesVenduDAO;
import fr.eni.encheres.exceptions.DALException;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.bo.Retraits;


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
	public final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?)";
	
	
	//avec l'utilisateurs
	private static final String SELECT_ALL ="select av.no_article, nom_article, av.[description], date_debut_encheres, date_fin_encheres,\n"
			+ "prix_initial, prix_vente, u.*, c.*\n"
			+ "from ARTICLES_VENDUS av \n"
			+ "inner join UTILISATEURS u on u.no_utilisateur = av.no_utilisateur\n"
			+ "inner join CATEGORIES c on c.no_categorie = av.no_categorie";
	
	//sans l'utiliosateurs
	/*private static final String SELECT_ALL ="select av.no_article, nom_article, av.[description], date_debut_encheres, date_fin_encheres,\n"
			+ "prix_initial, prix_vente, c.*\n"
			+ "from ARTICLES_VENDUS av \n"
			+ "inner join CATEGORIES c on c.no_categorie = av.no_categorie"; */
	
	private static final String SELECT_BY_ID ="SELECT av.no_article, nom_article, av.[description], date_debut_encheres, date_fin_encheres,\n"
			+ "prix_initial, prix_vente, u.*, c.* \n"
			+ "FROM ARTICLES_VENDUS av \n"
			+ "INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur\n"
			+ "INNER JOIN RETRAITS r ON r .no_article = av.no_article\n"
			+ "INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie "
			+ "WHERE av.no_article= ?"; 
	
	private static final String SELECT_BY_ID_USER ="SELECT av.no_article, nom_article, av.[description], date_debut_encheres, date_fin_encheres,\n"
			+ "prix_initial, prix_vente, u.*, c.* \n"
			+ "FROM ARTICLES_VENDUS av \n"
			+ "INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur\n"
			+ "INNER JOIN RETRAITS r ON r .no_article = av.no_article\n"
			+ "INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie "
			+ "WHERE u.no_utilisateur= ?"; 
	
	
	
	public final String DELETE = "Delete from ARTICLES_VENDUS where no_article = ?";

	public final String SELECT_LAST_INSERT_ID = "SELECT IDENT_CURRENT('ARTICLES_VENDUS') AS lastInsertId;";
	
	@Override
	public void insertArticle(ArticlesVendu article) throws DALException {
		try(Connection con = ConnectionProvider.connection()){
			PreparedStatement pStmt = con.prepareStatement(INSERT_ARTICLE);
			pStmt.setString(1, article.getArticleName());
			pStmt.setString(2, article.getDescription());
			pStmt.setDate(3,Date.valueOf(article.getDateStartEnchere()));
			pStmt.setDate(4,Date.valueOf(article.getDateEndEnchere()));
			pStmt.setInt(5, article.getPrixInitial());
			pStmt.setInt(6, article.getPrixVente());
			pStmt.setInt(7, article.getUtilisateur().getId());
			pStmt.setInt(8, article.getCategorie().getId());
			
			pStmt.executeUpdate();
		} catch(SQLException e) {
		throw new DALException("Impossible d'insérer l'article" + e.getMessage());
		}
	}

	public int selectLastInsertId() throws DALException {
		int result = 0;
		try(Connection con = ConnectionProvider.connection()){
			PreparedStatement pStmt = con.prepareStatement(SELECT_LAST_INSERT_ID);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("lastInsertId");
				result = id;
			}
		} catch(SQLException e) {
		throw new DALException("Aucun article a été inséré" + e.getMessage());
		}
		return result;
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
						
						Utilisateurs u = new Utilisateurs();
						u.setId(rs.getInt("no_utilisateur"));
						u.setFirstName(rs.getString("nom"));
						u.setLastName(rs.getString("prenom"));
						u.setPseudo(rs.getString("pseudo"));
						u.setEmail(rs.getString("email"));
						u.setPhoneNumber(rs.getString("telephone"));
						u.setStreet(rs.getString("rue"));
						u.setZipCode(rs.getString("code_postal"));
						u.setCity(rs.getString("ville"));
						u.setPassword(rs.getString("mot_de_passe"));
						u.setCredit(rs.getInt("credit"));
						u.setAdmin(rs.getBoolean("administrateur"));
						
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
	public ArticlesVendu SelectById(int no_article) throws DALException {
		//initilisation d'une liste d'article
		ArticlesVendu article = new ArticlesVendu();
		
		// ouvre une connexion à la base de donnée
		try (Connection con = ConnectionProvider.connection()){
			//On charge  et prépare la requête pour exécution
			PreparedStatement pst = con.prepareStatement(SELECT_BY_ID);
			pst.setInt(1, no_article);
			//on execute la requete et récupère les élement qu'lle nou retourne 
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {	
				
				int idU = rs.getInt("no_utilisateur");
				String lastName = rs.getString("nom");
				String firtName = rs.getString("prenom");
				String pseudo = rs.getString("pseudo");
				String email = rs.getString("email");
				String phone = rs.getString("telephone");
				String street = rs.getString("rue");
				String zipCode = rs.getString("code_postal");
				String city = rs.getString("ville");
				String password = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				Boolean admin = rs.getBoolean("administrateur");
				Utilisateurs user = new Utilisateurs(idU, pseudo, lastName, lastName, email, phone, street, zipCode, city, password, credit, admin);
				
				int idC = rs.getInt("no_categorie");
				String libelleC = rs.getString("libelle");
				Categories categorie = new Categories(idC, libelleC);
				
				Retraits retrait = new Retraits();
				retrait.setStreet(rs.getString("rue"));
				retrait.setZipCode(rs.getString("code_postal"));
				retrait.setCity(rs.getString("ville"));
				
				int idA = rs.getInt("no_article");
				String nameA = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();
				int prixDebut = rs.getInt("prix_initial");
				int prixVente = rs.getInt("prix_vente");
				
				article = new ArticlesVendu(idA, nameA, description, dateDebut, dateFin, prixDebut, prixVente, user, categorie, nameA, description, retrait);
				
			}
			//on retourne la liste d'utilisateur
			return article ;
		} 
		catch (SQLException e) {
			
			// en cas d'erreur on ajoute un message d'erreur à la liste des erreurs de l'objet SQLException créé. 
			throw new DALException("Fonction SelectByID ArticlVendusJDBCImpl " + e.getMessage());
		}
	}

	
	public List<ArticlesVendu> SelectByIdUser(int idUser) throws DALException {
		//initilisation d'une liste d'article
		List<ArticlesVendu> listeArticlesByUser = new ArrayList<>();
		
		// ouvre une connexion à la base de donnée
		try (Connection con = ConnectionProvider.connection()){
			//On charge  et prépare la requête pour exécution
			PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_USER);
			pst.setInt(1, idUser);
			//on execute la requete et récupère les élement qu'lle nou retourne 
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {	
				
				int idU = rs.getInt("no_utilisateur");
				String lastName = rs.getString("nom");
				String firtName = rs.getString("prenom");
				String pseudo = rs.getString("pseudo");
				String email = rs.getString("email");
				String phone = rs.getString("telephone");
				String street = rs.getString("rue");
				String zipCode = rs.getString("code_postal");
				String city = rs.getString("ville");
				String password = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				Boolean admin = rs.getBoolean("administrateur");
				Utilisateurs user = new Utilisateurs(idU, pseudo, lastName, lastName, email, phone, street, zipCode, city, password, credit, admin);
				
				int idC = rs.getInt("no_categorie");
				String libelleC = rs.getString("libelle");
				Categories categorie = new Categories(idC, libelleC);
				
				Retraits retrait = new Retraits();
				retrait.setStreet(rs.getString("rue"));
				retrait.setZipCode(rs.getString("code_postal"));
				retrait.setCity(rs.getString("ville"));
				
				int idA = rs.getInt("no_article");
				String nameA = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();
				int prixDebut = rs.getInt("prix_initial");
				int prixVente = rs.getInt("prix_vente");
				ArticlesVendu article = new ArticlesVendu(idA, nameA, description, dateDebut, dateFin, prixDebut, prixVente, user, categorie, nameA, description, retrait);
				
				listeArticlesByUser.add(article);
			}
			//on retourne la liste d'utilisateur
			return listeArticlesByUser ;
		} 
		catch (SQLException e) {
			
			// en cas d'erreur on ajoute un message d'erreur à la liste des erreurs de l'objet SQLException créé. 
			throw new DALException("Fonction SelectByID ArticlVendusJDBCImpl " + e.getMessage());
		}
	}
	

	@Override
	public void Delete(int no_article) throws DALException {
		// TODO Auto-generated method stub
try(Connection con = ConnectionProvider.connection()){
			
			PreparedStatement pst = con.prepareStatement(DELETE);
			
			pst.setInt(1, no_article);
			pst.executeUpdate();

		} catch (SQLException e) {
			// en cas d'erreur on ajoute un message d'erreur à la liste des erreurs de l'objet SQLException créé. 
			throw new DALException("Erreur, une erreur s'est produite dans la suppression de la vente " );
		}
	}


	@Override
	public List<ArticlesVendu> SelectArticleUtilisateur() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*public List<ArticleVendu> SelectArticleutilisateur() throws DALException {
		//initilisation d'une liste d'article
		List<Article_vendus> vListArticleVendu = new ArrayList<Article_vendus>();
		
		String requete = "select a.*, u.*, c.* from ARTICLES_VENDUS a \n"
				+ "inner join UTILISATEURS u on u.no_utilisateur = a.no_utilisateur\n"
				+ "inner join CATEGORIES c on c.no_categorie = a.no_categorie\n"
	
			

			//on execute la requete et récupère les élement qu'lle nou retourne 
			ResultSet rs = ps.executeQuery();	*/
			
			/*
			 * Pour chaque ligne de la liste retouné 
			 * on crée un objet de type utilisateur qu'on va associé à chaque colonne de notre ligne 
			 * puis on va ajouter l'ojet region à notre liste d'utilisateurs
			 */
		/*	while (rs.next()) {
				//initialisation d'un objet Article_Vendus
				Article_vendus vArticleVendu = new Article_vendus();
				vArticleVendu.setNo_article(rs.getInt("no_article"));
				vArticleVendu.setNom_article(rs.getString("nom_article"));
				vArticleVendu.setDescription(rs.getString("description"));
				vArticleVendu.setDate_debut_enchere(rs.getDate("date_debut_enchere").toLocalDate());
				vArticleVendu.setDate_fin_enchere(rs.getDate("date_fin_enchere").toLocalDate());
				vArticleVendu.setPrix_initial(rs.getInt("prix_initial"));
				vArticleVendu.setPrix_vente(rs.getInt("prix_vente"));
				
				Utilisateurs u = new Utilisateurs();
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
				u.setAministrateur(rs.getBoolean("administrateur"));
				
				vArticleVendu.setUtilisateur(u);
				Categories c = new Categories();
				c.setNo_categorie(rs.getInt("no_categorie"));
				c.setLibelle(rs.getString("libelle"));
				
				vArticleVendu.setCategorie(c);
				vArticleVendu.setEtat_vente(rs.getString("etat_vente"));
				vListArticleVendu.add(vArticleVendu);
			}
			
			//on retourne la liste d'utilisateur
			return vListArticleVendu ;
		} 
		catch (SQLException e) {
			
			// en cas d'erreur on ajoute un message d'erreur à la liste des erreurs de l'objet SQLException créé. 
			throw new DALException("Fonction SelectArticleutilisateur ArticlVendusJDBCImpl " + e.getMessage());
		}
	}*/
	
}
