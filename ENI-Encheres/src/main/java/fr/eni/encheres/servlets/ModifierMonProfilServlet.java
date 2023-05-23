package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.interfaces.UtilisateursDAO;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;
import fr.eni.encheres.exceptions.BllException;
import fr.eni.encheres.exceptions.DALException;

import fr.eni.encheres.exceptions.BllException;
import fr.eni.encheres.exceptions.DALException;
import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.Utilisateurs;

@WebServlet("/ModifierMonProfil")
public class ModifierMonProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifierMonProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    
	    if (session != null && session.getAttribute("utilisateur") != null) {
	    	request.getRequestDispatcher("/WEB-INF/jsp/modifierMonProfil.jsp").forward(request, response);
	    } else {
	        response.sendRedirect("Connexion");
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		
		List<String> erreurs = new ArrayList<>();
		UtilisateursDAO utilisateurDAO = new DAOFactory().getUtilisateurDAO();
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("utilisateur") != null) {
			Utilisateurs util = (Utilisateurs) session.getAttribute("utilisateur");
			int id = util.getId();
	
		String pseudo = request.getParameter("pseudo");
=======
		// Récupérer les valeurs des paramètres depuis la requête
	    String pseudo = request.getParameter("pseudo");
>>>>>>> 1578e47f46ce051df220be34d8829b81f641267b
	    String lastName = request.getParameter("lastName");
	    String firstName = request.getParameter("firstName");
	    String email = request.getParameter("email");
	    String phoneNumber = request.getParameter("phoneNumber");
	    String street = request.getParameter("street");
	    String zipCode = request.getParameter("zipCode");
	    String city = request.getParameter("city");
<<<<<<< HEAD
	    String password = request.getParameter("password");
	    String newPassword = request.getParameter("newPassword");
	    String confirmNewPassword = request.getParameter("confirmNewPassword");
	    
	    
	    try {
	    	if (password!=null && password.equals(util.getPassword())) {
	    		if ((newPassword == null && confirmNewPassword == null) || (newPassword == "" && confirmNewPassword == "")) {
	    			utilisateurManager.getInstance().update(id,pseudo, firstName, lastName, email, phoneNumber, street, zipCode, city, password);
	    			Utilisateurs utilisateurMisAJour = utilisateurDAO.getUserById(id);
	    		    session.setAttribute("utilisateur", utilisateurMisAJour);
			    	response.sendRedirect("MonProfil");
	    		}
	    		if (newPassword != null && newPassword != "" && confirmNewPassword != null && confirmNewPassword != "" && newPassword.equals(confirmNewPassword)){
	    			utilisateurManager.getInstance().update(id,pseudo, firstName, lastName, email, phoneNumber, street, zipCode, city, confirmNewPassword);	    			
	    			Utilisateurs utilisateurMisAJour = utilisateurDAO.getUserById(id);
	    		    session.setAttribute("utilisateur", utilisateurMisAJour);
			    	response.sendRedirect("MonProfil");
	    		} else if (newPassword != confirmNewPassword) {
	    			erreurs.add("Le mot de passe de confirmation ne correspond pas au nouveau mot de passe.");
	    		}
	    	} else {
	    		erreurs.add("Le mot de passe actuel n'est pas correct.");
	    	}
	        
	    } catch (DALException e) {
	        response.sendRedirect("error");
	    } catch (BllException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    if (!erreurs.isEmpty()) {
		    request.setAttribute("erreurs", erreurs);
		    request.getRequestDispatcher("/WEB-INF/jsp/modifierMonProfil.jsp").forward(request, response);
		}
	    }else {
	        response.sendRedirect("Connexion");
	    }
=======

	    // Créer un objet Utilisateurs avec les valeurs récupérées
	    Utilisateurs user = new Utilisateurs(pseudo, firstName, lastName, email, phoneNumber, street, zipCode, city, city);
	    
	    try {
	    	utilisateurManager.getInstance().update(user);
	        // La mise à jour a réussi, vous pouvez rediriger l'utilisateur vers une page de succès
	        response.sendRedirect("MonProfil.jsp");
	    } catch (DALException e) {
	        // Une erreur s'est produite lors de la mise à jour, vous pouvez rediriger l'utilisateur vers une page d'erreur
	        response.sendRedirect("error.jsp");
	    } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BllException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
>>>>>>> 1578e47f46ce051df220be34d8829b81f641267b
	}
}