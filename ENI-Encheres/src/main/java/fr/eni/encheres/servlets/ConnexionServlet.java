package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession(false);
	    
	    if (session != null && session.getAttribute("utilisateur") != null) {
	    	response.sendRedirect("http://localhost:8080/ENI-Encheres/");
	    } else {
	    	request.setAttribute("pageTitle", "Connexion");
	        request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	    }
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("btnConnexion") != null) {
			
			List<String> erreurs = new ArrayList<>();
			
			String identifiant = request.getParameter("identifiant");
			String password = request.getParameter("password");
			
				try {
					Utilisateurs utilisateur  = utilisateurManager.getInstance().login(identifiant, password);
					if (utilisateur != null) {
						HttpSession session = request.getSession(true);
		                session.setAttribute("utilisateur", utilisateur);
		                response.sendRedirect("http://localhost:8080/ENI-Encheres/");
		                return;
//						utilisateurManager.getInstance().login(identifiant, password);
//						request.setAttribute("valide", "Vous êtes connecté !");
//						response.sendRedirect("http://localhost:8080/ENI-Encheres/");
//						return;
					} else {
						erreurs.add("L'identifiant ou le mot de passe est incorrect !");
					}
				} catch (Exception e) {
		            erreurs.add("Une erreur s'est produite lors de la connexion");
		            e.printStackTrace();
		        }
			
			if (!erreurs.isEmpty()) {
			    request.setAttribute("erreurs", erreurs);
			}
		} else if (request.getParameter("btnInscription") != null) {
			response.sendRedirect("Inscription");
		}
		
	}
}

