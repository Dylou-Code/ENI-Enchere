package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.connection.ConnectionProvider;

public class ArticlesVenduDAOJdbcImpl {

	public final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom, description,date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, r\n) VALUES (?,?,?,?,?,?)";
	public final String DELETE = "Delete from ARTICLES_VENDUS where no_article = ?";
	
	
	public void insertArticles(ArticlesVendu articleVendu) throws DALException{
		ArticlesVendu articlesVendu = new ArticlesVendu();
		/*Categories categorie = new Categories();*/
		try(Connection con = ConnectionProvider.connection()){
			PreparedStatement pStmt = con.prepareStatement(INSERT_ARTICLE);
			/**/
			pStmt.setString(1, articleVendu.getArticleName());
			pStmt.setString(2, articleVendu.getDescription());
			pStmt.setDate(3, articleVendu.getDateStartEnchere());
			pStmt.setInt(4, articleVendu.getDateEndEnchere());
			pStmt.setInt(5, articleVendu.getPrixInitial());
			pStmt.setInt(6, articleVendu.getPrixVente());
			pStmt.setUtilisateur(7, articleVendu.getUtilisateur());
			pStmt.setString(8, articleVendu.getCategorie());
			pStmt.setString(9, articleVendu.getEtat_vente());

			pStmt.executeUpdate();
			
		} catch(SQLException e) {
		throw new DALException("Impossible d'insérer l'utilisateur", e);
		}
		
	}
}
