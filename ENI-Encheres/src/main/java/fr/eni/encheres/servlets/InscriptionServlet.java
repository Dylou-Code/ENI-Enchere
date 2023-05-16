package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.registerManager;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/formulaires/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
				
		
				String pseudo = request.getParameter("pseudo");
		        String firstName = request.getParameter("firstName");
		        String lastName = request.getParameter("lastName");
		        String email = request.getParameter("email");
		        String phoneNumber = request.getParameter("phoneNumber");
		        String street = request.getParameter("street");
		        String zipCode = request.getParameter("zipCode");
		        String city = request.getParameter("city");
		        String password = request.getParameter("password");
		        String confirmPassword = request.getParameter("confirmPassword");
		        
		        
		       if(password == confirmPassword) {
		    	   
			     registerManager inputRegister = new registerManager();
			        try {
			        	inputRegister.register(pseudo, firstName, lastName, email, phoneNumber, street, zipCode, city, confirmPassword);
			        } catch (Exception e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        }

			        response.sendRedirect("/WEB-INF/jsp/Home.jsp");
		    	   
		       } else {
		    	   System.out.println("Veuillez vérifier vos informations");
		       }
		        
		    }

}
