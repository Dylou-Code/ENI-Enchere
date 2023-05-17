package fr.eni.encheres.dal.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.encheres.exceptions.ExceptionTechnique;

public abstract class ConnectionProvider {
	private static DataSource datasource;
	
	
	static {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}
}
