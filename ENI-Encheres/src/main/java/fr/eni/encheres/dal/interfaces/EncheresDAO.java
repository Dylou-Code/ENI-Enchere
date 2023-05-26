package fr.eni.encheres.dal.interfaces;

import java.util.List;

import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.exceptions.DALException;

public abstract interface EncheresDAO {
	

	public abstract List<Encheres> getAllAuctions() throws DALException;
	public abstract List<Encheres> getAllAuctionsByIdUser(int idUser) throws DALException;
	public abstract void insertAuction(Encheres enchere) throws DALException;
}
