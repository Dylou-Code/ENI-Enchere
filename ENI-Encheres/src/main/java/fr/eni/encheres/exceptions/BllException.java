package fr.eni.encheres.exceptions;
import java.util.*;
public class BllException extends Exception {

	private static final long serialVersionUID = 1L;

	private static List<String> errorList = new ArrayList<>();
	
	public void addErreur(String errorMessage) {
		// TODO Auto-generated method stub
		errorList.add(errorMessage);
	}
	
	public static List<String> getErrorList() {
		return errorList;
	}
	
	public boolean withErrors() {
		return !errorList.isEmpty();
	}
}
