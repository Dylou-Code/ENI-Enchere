package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Retraits;

public class RetraitsManager {
	
	public static RetraitsManager retraitsManager; 
	
	public static RetraitsManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception{
		if(retraitsManager == null) {
			retraitsManager = new RetraitsManager();
		}
		return retraitsManager;
	}
	// a faire Dylan
	public void ajouterRetraits(Retraits retrait) {
		
		
	}
	
	
	
	
}
