package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.interfaces.UtilisateursDAO;
import fr.eni.encheres.exceptions.DALException;

@WebServlet("/Profil")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Définissez les attributs pour les données à transmettre à la JSP
        request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer le pseudo de recherche depuis le formulaire
	    String pseudoRecherche = request.getParameter("pseudoRecherche");

	    // Créer une instance de DAOFactory
	    DAOFactory daoFactory = new DAOFactory();

	    // Récupérer l'instance de UtilisateursDAO depuis DAOFactory
	    UtilisateursDAO userDAO = daoFactory.getUtilisateurDAO();

	    // Récupérer l'utilisateur en fonction du pseudo de recherche
	    Utilisateurs user = null;
		try {
			user = userDAO.getUserByPseudo(pseudoRecherche);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Vérifier si le pseudo existe dans la base de données
	    if (user != null) {
	        // Définir les attributs pour les données à transmettre à la JSP
	        request.setAttribute("pseudo", user.getPseudo());
	        request.setAttribute("lastName", user.getLastName());
	        request.setAttribute("firstName", user.getFirstName());
	        request.setAttribute("email", user.getEmail());
	        request.setAttribute("phoneNumber", user.getPhoneNumber());
	        request.setAttribute("street", user.getStreet());
	        request.setAttribute("zipCode", user.getZipCode());
	        request.setAttribute("city", user.getCity());  

	        // Transmettre la requête à la JSP
	        request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
	    } else {
	        // Gérer le cas où le pseudo n'existe pas dans la base de données
	        // Par exemple, afficher un message d'erreur ou rediriger vers une autre page
	        response.sendRedirect("erreur");
	    }
	}
}