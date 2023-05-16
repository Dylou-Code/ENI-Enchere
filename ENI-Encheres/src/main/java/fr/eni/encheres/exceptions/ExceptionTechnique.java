package fr.eni.encheres.exceptions;

import java.sql.SQLException;

public class ExceptionTechnique extends RuntimeException{

	public ExceptionTechnique(String string) {
		super(string);
	}

	public ExceptionTechnique(String string, SQLException e) {
		super(string, e);
	}

	private static final long serialVersionUID = 1L;

}
