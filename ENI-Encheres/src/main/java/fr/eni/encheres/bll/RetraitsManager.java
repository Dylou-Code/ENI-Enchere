package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.interfaces.RetraitsDAO;
import fr.eni.encheres.dal.interfaces.UtilisateursDAO;


public class RetraitsManager {
	private RetraitsDAO retraitDAO; 
	public static RetraitsManager retraitManager;; 
	
	public RetraitsManager() {
		retraitDAO = new DAOFactory().getRetraitsDAO(); // Initialisation du DAO des utilisateurs
	}
	//Permet d'obtenir l'instance de la classe qui existe sinon elle se crée
	public static RetraitsManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception{
		
		if(retraitManager == null) {
			retraitManager = new RetraitsManager();
		}
		return retraitManager;
	}
	
	
	public void ajouterRetraits(Retraits retrait) {
		// TODO Auto-generated method stub
		
	}
}
