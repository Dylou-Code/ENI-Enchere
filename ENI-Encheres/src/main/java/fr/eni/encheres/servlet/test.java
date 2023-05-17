package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< Updated upstream:ENI-Encheres/src/main/java/fr/eni/encheres/servlet/test.java
/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public test() {
=======
@WebServlet("/Encheres")
public class EncheresServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EncheresServlets() {
        super();
>>>>>>> Stashed changes:ENI-Encheres/src/main/java/fr/eni/encheres/servlets/EncheresServlets.java
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
<<<<<<< Updated upstream:ENI-Encheres/src/main/java/fr/eni/encheres/servlet/test.java

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
=======
}
>>>>>>> Stashed changes:ENI-Encheres/src/main/java/fr/eni/encheres/servlets/EncheresServlets.java
