package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;

import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.dal.connection.ConnectionProvider;
import fr.eni.encheres.dal.interfaces.ArticlesVenduDAO;
import fr.eni.encheres.exceptions.DALException;

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
	
	public final String SELECT_ALL = "select av.no_article, nom_article, av.[description], date_debut_enchere, date_fin_enchere,\\n\"\r\n"
			+ "	+ \"prix_initial, prix_vente, u.*, c.*, etat_vente \\n\"\r\n"
			+ "	+ \"from ARTICLES_VENDUS av \\n\"\r\n"
			+ "	+ \"inner join UTILISATEURS u on u.no_utilisateur = av.no_utilisateur\\n\"\r\n"
			+ "	+ \"inner join CATEGORIES c on c.no_categorie = av.no_categorie\"; ";
	
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
		List<ArticlesVendu> vListArticleVendu = new ArrayList<ArticlesVendu>();
	}


	@Override
	public void Delete(int no_article) throws DALException {
		// TODO Auto-generated method stub
		
	}
}
