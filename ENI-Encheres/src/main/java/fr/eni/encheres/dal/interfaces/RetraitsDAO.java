package fr.eni.encheres.dal.interfaces;

import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.exceptions.DALException;

public interface RetraitsDAO {

	public abstract void insertRetrait(Retraits retrait) throws DALException;
	public abstract Retraits SelectByIdArticle(int idArticle) throws DALException;

}
