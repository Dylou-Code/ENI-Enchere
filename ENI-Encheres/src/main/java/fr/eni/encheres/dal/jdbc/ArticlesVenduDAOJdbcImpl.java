package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;

import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.connection.ConnectionProvider;
import fr.eni.encheres.dal.interfaces.ArticlesVenduDAO;
import fr.eni.encheres.exceptions.DALException;

public class ArticlesVenduDAOJdbcImpl implements ArticlesVenduDAO{

	public final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom, description,date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, r\n)"
			+ "date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image) \r\n"
			+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
	
	public final String DELETE = "Delete from ARTICLES_VENDUS where no_article = ?";
	
	
	public void insertArticles(ArticlesVendu articleVendu) throws DALException{

		
		/*Categories categorie = new Categories();*/
		try(Connection con = ConnectionProvider.connection()){
			PreparedStatement pStmt = con.prepareStatement(INSERT_ARTICLE);
			/*Ajout des différentes methodes  getUtilisateur et gestion des dates*/
			pStmt.setString(1, articleVendu.getArticleName());
			pStmt.setString(2, articleVendu.getDescription());
			pStmt.setDate(3,java.sql.Date.valueOf(articleVendu.getDateStartEnchere()));
			pStmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDateEndEnchere()));
			pStmt.setInt(5, articleVendu.getPrixInitial());
			pStmt.setInt(6, articleVendu.getPrixVente());
			pStmt.setInt(7, articleVendu.getUtilisateur.getId());
			pStmt.setString(8, articleVendu.getCategories.getNo_utilisateur());
			pStmt.setString(9, articleVendu.getEtat_vente());

			pStmt.executeUpdate();
			
		} catch(SQLException e) {
		throw new DALException("Impossible d'insérer l'utilisateur", e);
		}
	}


	@Override
	public void insertArticle(ArticlesVendu articleVendu) throws DALException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void Update(ArticlesVendu articleVendu) throws DALException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ArticlesVendu> SelectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void Delete(int no_article) throws DALException {
		// TODO Auto-generated method stub
		
	}
}
