package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.registerManager;
import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.UtilisateurDAO;
import projetEncheres.eni.fr.BLL.UtilisateursManager;
import projetEncheres.eni.fr.IHM.Exception;
import projetEncheres.eni.fr.IHM.SQLException;

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

	//Url inscription
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
				
		/*
				String pseudo = request.getParameter("pseudo");
		        String firstName = request.getParameter("firstName");
		        String lastName = request.getParameter("lastName");
		        String email = request.getParameter("email");
		        String phoneNumber = request.getParameter("phoneNumber");
		        String street = request.getParameter("street");
		        String zipCode = request.getParameter("zipCode");
		        String city = request.getParameter("city");
		        String password = request.getParameter("password");
		        String confirmPassword = request.getParameter("confirmPassword");*/
		        
		        
		        if(!request.getParameter("pseudo").isEmpty()
		    			&& !request.getParameter("firstName").isEmpty() 
		    			&& !request.getParameter("lastName").isEmpty() 
		    			&& !request.getParameter("email").isEmpty() 
		    			&& !request.getParameter("phoneNumber").isEmpty()
		    			&& !request.getParameter("zipCode").isEmpty()
		    			&& !request.getParameter("cp").isEmpty()
		    			&& !request.getParameter("ville").isEmpty()
		    			&& !request.getParameter("password").isEmpty()
		    			&& !request.getParameter("confirmPassword").isEmpty()) {
		    			if(request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
		    				
		    				Utilisateurs Utilisateurs = new Utilisateurs(0, request.getParameter("pseudo"), 
		    						request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"), 
		    						request.getParameter("tel"), request.getParameter("rue"), request.getParameter("cp"), 
		    						request.getParameter("ville"), request.getParameter("pswd"), 100, false);
		    				
		    				try {
		    					
		    					utilisateurManager.getInstance().register(Utilisateurs);;
		    					request.setAttribute("valide", "Vous êtes bien inscrit");
		    					
		    				} catch (SQLException e) {
		    					
		    					request.setAttribute("message", "Le pseudo ou l'adresse mail est déjà utilisé");
		    					e.printStackTrace();
		    					
		    				} catch (Exception e) {
		    					
		    					request.setAttribute("message", "Une erreur s'est produite lors de la création");
		    					e.printStackTrace();
		    				}
		    			}else {
		    				request.setAttribute("message", "Le mot de passe doit être le même que la confirmation");
		    			}
		    		}else {
		    			request.setAttribute("message", "Tous les champs doivent être remplis");
		    		}
		    		
		    		doGet(request, response);
		        
		    }

}
