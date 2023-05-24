package fr.eni.encheres.dal.interfaces;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.exceptions.DALException;

public abstract interface UtilisateursDAO {

	public abstract List<Utilisateurs> getAllUsers() throws DALException;
	public abstract List<String> getPseudos() throws DALException;
	public abstract List<String> getEmails() throws DALException;
	public abstract Utilisateurs getUserByPseudo(String pseudo) throws DALException;
	public abstract Utilisateurs getUserByEmail(String email) throws DALException;
	public abstract Utilisateurs getUserById(int id) throws DALException;
	public abstract void insertUser(Utilisateurs user) throws DALException;
	public abstract void updateUser(int id, String pseudo, String firstName, String lastName, String email, String phoneNumber, String street, String zipCode, String city, String password) throws DALException;
	public abstract void deleteUser(String pseudo) throws DALException;
}
