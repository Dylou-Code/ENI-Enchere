package fr.eni.encheres.dal.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.encheres.exceptions.ExceptionTechnique;

public abstract class ConnectionProvider {
	private static Context context;
	private static DataSource datasource;
	
	private static boolean initialisationOK = true;
	
	static {
		try {
			context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			initialisationOK = false;
		}
	}
	
	public static Connection connection() throws SQLException {
		if(initialisationOK) {
			return datasource.getConnection();
		}
		throw new ExceptionTechnique("Echec de l'initialisation de la connexion JDBC");
	}

}
