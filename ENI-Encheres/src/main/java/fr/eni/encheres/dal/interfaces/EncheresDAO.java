package fr.eni.encheres.dal.interfaces;

import java.util.List;

import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.exceptions.DALException;

public abstract interface EncheresDAO {
	

	public List<Encheres> getAllAuctions() throws DALException;
	public Encheres getAllAuctionsByIdUser(int idUser) throws DALException;
	public void insertAuction(Encheres enchere) throws DALException;
}
