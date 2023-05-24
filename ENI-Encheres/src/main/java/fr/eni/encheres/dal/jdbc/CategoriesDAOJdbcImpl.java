package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.connection.ConnectionProvider;
import fr.eni.encheres.dal.interfaces.CategoriesDAO;
import fr.eni.encheres.exceptions.DALException;

public class CategoriesDAOJdbcImpl implements CategoriesDAO {
	
	private static final String SELECT_ALL ="Select * from CATEGORIES"; 
	
	@Override
	public List<Categories> SelectALL() throws DALException {
		//Initilisation d'une liste d'utilisateurs 
		List<Categories> ListCategorie = new ArrayList<Categories>();
		
		// ouvre une connexion à la base de donnée
		try (Connection con = ConnectionProvider.connection()){
			//On charge  et prépare la requête pour exécution
			PreparedStatement pst = con.prepareStatement(SELECT_ALL);
			
			//on execute la requete et récupère les élement qu'lle nou retourne 
			ResultSet rs = pst.executeQuery();	
			
			/*
			 *Nom catégorie à changer
			 */
			while (rs.next()) {
				Categories Categorie = new Categories(); 
				Categorie.setId(rs.getInt("no_categorie"));
				Categorie.setName(rs.getString("libelle"));
				ListCategorie.add(Categorie);
			}
			
			//Retour de la liste
			return ListCategorie ;
		} 
		catch (SQLException e) {
			
			// en cas d'erreur on ajoute un message d'erreur à la liste des erreurs de l'objet SQLException créé. 
			throw new DALException("Fonction SelectALL CategoriesJDBCImpl " + e.getMessage());
		}
	}

	@Override
	public void Insert(Categories categorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Categories categorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categories SelectById(int no_categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(int no_categorie) {
		// TODO Auto-generated method stub
		
	}
}
