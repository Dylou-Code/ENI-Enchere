package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.dal.connection.ConnectionProvider;
import fr.eni.encheres.dal.interfaces.EncheresDAO;
import fr.eni.encheres.exceptions.DALException;
import java.util.ArrayList;
import java.util.List;

public class EncheresDAOJdbcImpl implements EncheresDAO{
	public final String SELECT_ALL = "SELECT * FROM ENCHERES";
	public final String SELECT_BY_ID_USER = "SELECT * FROM ENCHERES WHERE no_utilisateur=?";
	public final String INSERT_AUCTION = "INSERT INTO ENCHERES(date_enchere, montant_enchere, no_article, no_utilisateur) VALUES (?,?,?,?)";
	
	public List<Encheres> getAllAuctions() throws DALException {
		List<Encheres> resultat = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.connection()){
			PreparedStatement pst = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pst.executeQuery(SELECT_ALL);
			
			while(rs.next()) {
				int id = rs.getInt("no_enchere");
				Date date = rs.getDate("date_enchere");
				int montant = rs.getInt("montant_enchere");
				int idArticle = rs.getInt("no_article");
				int idUser = rs.getInt("no_utilisateur");
				
				resultat.add(new Encheres(id, date, montant, idArticle, idUser));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DALException("Erreur à la sélection des enchères", e);
		}
		
		return resultat;
	}

	public Encheres getAllAuctionsByIdUser(int id) throws DALException {
		//Connection con=null;
		//PreparedStatement pStmt= null;
		List<Encheres> resultat = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.connection()){
			PreparedStatement pStmt = con.prepareStatement(SELECT_BY_ID_USER);
			
			pStmt.setInt(1, id);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("no_enchere");
				Date date = rs.getDate("date_enchere");
				int montant = rs.getInt("montant_enchere");
				int idArticle = rs.getInt("no_article");
						
				Encheres enchere = new Encheres(id, date, montant, idArticle, id);
				resultat.add(enchere);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Aucune enchère n'est associé à l'utilisateur ayant pour id : " + id, e);
		}
		
		return (Encheres) resultat;
	}

	
	public void insertAuction(Encheres enchere) throws DALException {
		try(Connection con = ConnectionProvider.connection()){
				PreparedStatement pStmt = con.prepareStatement(INSERT_AUCTION, Statement.RETURN_GENERATED_KEYS);
				pStmt.setDate(1, enchere.getDate());
				pStmt.setInt(2, enchere.getPrice());
				pStmt.setInt(3, enchere.getIdArticle());
				pStmt.setInt(4, enchere.getIdUser());

				pStmt.executeUpdate();
			}catch(SQLException e) {
				throw new DALException("Impossible d'insérer l'enchère", e);
			}
		
	}

}
