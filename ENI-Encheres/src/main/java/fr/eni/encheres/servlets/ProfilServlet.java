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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	    // Récupérer le pseudo de recherche depuis le formulaire
	    String pseudoRecherche = request.getParameter("pseudoRecherche");

	    
	    DAOFactory daoFactory = new DAOFactory();
	    UtilisateursDAO userDAO = new DAOFactory().getUtilisateurDAO();
	    Utilisateurs user = userDAO.getUserByPseudo(pseudoRecherche);
	
	    // Vérifier si le pseudo existe dans la base de données
	    if (user != null) {
	    	request.setAttribute(request.getParameter("pseudo"), user.getPseudo());
	    	request.setAttribute(request.getParameter("lastName"), user.getLastName());
	    	request.setAttribute(request.getParameter("firstName"), user.getFirstName());
	    	request.setAttribute(request.getParameter("email"), user.getEmail());
	    	request.setAttribute(request.getParameter("phoneNumber"), user.getPhoneNumber());
	    	request.setAttribute(request.getParameter("street"), user.getStreet());
	    	request.setAttribute(request.getParameter("zipCode"), user.getZipCode());
	    	request.setAttribute(request.getParameter("city"), user.getCity());  
		}	
	}
}