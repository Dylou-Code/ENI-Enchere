package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/modifierMonProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer les valeurs des paramètres depuis la requête
	    String pseudo = request.getParameter("pseudo");
	    String lastName = request.getParameter("lastName");
	    String firstName = request.getParameter("firstName");
	    String email = request.getParameter("email");
	    String phoneNumber = request.getParameter("phoneNumber");
	    String street = request.getParameter("street");
	    String zipCode = request.getParameter("zipCode");
	    String city = request.getParameter("city");

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
	}
}