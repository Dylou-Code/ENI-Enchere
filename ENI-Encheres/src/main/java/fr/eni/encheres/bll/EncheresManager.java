package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.interfaces.EncheresDAO;
import fr.eni.encheres.exceptions.DALException;

public class EncheresManager {

	private EncheresDAO enchereDAO; 
	public static EncheresManager enchereManager;; 

	public EncheresManager() {
		enchereDAO = new DAOFactory().getEncheresDAO(); // Initialisation du DAO des utilisateurs
	}
	//Permet d'obtenir l'instance de la classe qui existe sinon elle se crée
	public static EncheresManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception{

		if(enchereManager == null) {
			enchereManager = new EncheresManager();
		}
		return enchereManager;
	}

	//Sélection de toutes les enchères
	public List<Encheres> getAllAuction() throws DALException{
		return enchereDAO.getAllAuctions();
	}

	//Sélection de toutes les enchères pour un utilisateur donné
	public List<Encheres> getAllAuctionByUser(int id) throws DALException{
		return enchereDAO.getAllAuctionsByIdUser(id);
	}
	
	public void insert(Encheres enchere) throws DALException{
		enchereDAO.insertAuction(enchere);
	}
}
