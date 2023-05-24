package fr.eni.encheres.dal.interfaces;

import java.util.List;

import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.exceptions.DALException;

/*
 * définit les méthodes permettant d'interagir avec la base de données pour la
 *  gestion des utilisateurs
 *   L'interface permet de définir un contrat commun pour toutes les implémentations de la classe DAO
 * */
public abstract interface ArticlesVenduDAO {

	public abstract void insertArticle(ArticlesVendu articleVendu) throws DALException;
	public abstract void Update(ArticlesVendu articleVendu) throws DALException;
	public abstract List<ArticlesVendu> SelectAll()throws DALException;
	public abstract ArticlesVendu SelectById(int no_article) throws DALException;
	public abstract void Delete(int no_article) throws DALException;
	public abstract List<ArticlesVendu> SelectArticleUtilisateur ()throws DALException;
	//filtre à ajouter
}
