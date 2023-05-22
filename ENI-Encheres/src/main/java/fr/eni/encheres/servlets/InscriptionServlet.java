package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.interfaces.UtilisateursDAO;
import java.util.ArrayList;
import java.util.List;

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
		        
		        
		List<String> erreurs = new ArrayList<>();
        
        if(!request.getParameter("pseudo").isEmpty()
    			&& !request.getParameter("firstName").isEmpty() 
    			&& !request.getParameter("lastName").isEmpty() 
    			&& !request.getParameter("email").isEmpty() 
    			&& !request.getParameter("phoneNumber").isEmpty()
    			&& !request.getParameter("zipCode").isEmpty()
    			&& !request.getParameter("street").isEmpty()
    			&& !request.getParameter("city").isEmpty()
    			&& !request.getParameter("password").isEmpty()
    			&& !request.getParameter("confirmPassword").isEmpty()) {
    			if(request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
    				
    				Utilisateurs user = new Utilisateurs(0, request.getParameter("pseudo"), 
    						request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"), 
    						request.getParameter("phoneNumber"), request.getParameter("zipCode"), request.getParameter("street"), 
    						request.getParameter("city"), request.getParameter("confirmPassword"), 100, false);
    				
    				try {
    					
//    					String erreur = utilisateurManager.getInstance().register(user);
//    					if (erreur == null) {
    						utilisateurManager.getInstance().register(user);
	    					request.setAttribute("valide", "Vous êtes bien inscrit");
	    					response.sendRedirect("Connexion");
	    					return;
//    					}else {
//    					    // Il y a des erreurs, affichez-les
//    					    request.setAttribute("message", "Erreurs lors de l'inscription :");
//    					    request.setAttribute("erreurs", erreur);
//    					}
    					
    					
    				} catch (SQLException e) {
    		            erreurs.add("Le pseudo ou l'adresse mail est déjà utilisé");
    		            e.printStackTrace();
    		        } catch (Exception e) {
    		            erreurs.add("Une erreur s'est produite lors de la création");
    		            e.printStackTrace();
    		        }
    		    } else {
    		        erreurs.add("Le mot de passe doit être le même que la confirmation");
    		    }
    		} else {
    		    erreurs.add("Tous les champs doivent être remplis");
    		}

    		if (!erreurs.isEmpty()) {
    		    request.setAttribute("erreurs", erreurs);
    		}
}

}
