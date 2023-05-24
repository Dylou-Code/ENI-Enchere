package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.dal.interfaces.RetraitsDAO;

public class RetraitsManager {

	public static RetraitsManager retraitsManager;
	private RetraitsDAO retraitsDAO;
	
	public static RetraitsManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception{
		if(retraitsManager == null) {
			retraitsManager = new RetraitsManager();
		}
		return retraitsManager;
	}

	public void ajouterRetraits(Retraits retrait) {
		// TODO Auto-generated method stub
		
	}
}