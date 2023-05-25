package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.dal.connection.ConnectionProvider;
import fr.eni.encheres.dal.interfaces.RetraitsDAO;
import fr.eni.encheres.exceptions.DALException;

public class RetraitsDAOJdbcImpl implements RetraitsDAO {
		
	public final String INSERT_RETRAIT = "INSERT INTO RETRAITS(no_article,rue,code_postal,ville) VALUES (?,?,?,?)";
	public final String SELECT_BY_ID_ARTICLE = "SELECT * FROM RETRAITS WHERE no_article = ?";

	@Override
	public void insertRetrait(Retraits retrait) throws DALException {
		try(Connection con = ConnectionProvider.connection()){
			PreparedStatement pStmt = con.prepareStatement(INSERT_RETRAIT);
			pStmt.setInt(1, retrait.getArticle().getNo_article());
			pStmt.setString(2, retrait.getStreet());
			pStmt.setString(3, retrait.getZipCode());
			pStmt.setString(4, retrait.getCity());
			
			pStmt.executeUpdate();
		} catch(SQLException e) {
		throw new DALException("Impossible d'insérer le retrait" + e.getMessage());
		}
		
	}

	@Override
	public Retraits SelectByIdArticle(int idArticle) throws DALException {
		Retraits resultat = null;
			
			try(Connection con = ConnectionProvider.connection()){ 
				PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_ARTICLE);
				pst.setInt(1, idArticle);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					String rue = rs.getString("rue");
					String cp = rs.getString("code_postal");
					String ville = rs.getString("ville");
							
					resultat = new Retraits(rue, cp, ville);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DALException("Impossible de sélectionner la categorie ayant l'id " + idArticle, e);
			}
			return resultat;
		}
}
