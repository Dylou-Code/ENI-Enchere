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

import fr.eni.encheres.bll.utilisateurManager;

@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Effectuez ici les traitements nécessaires pour préparer les données de votre page

        // Définissez les attributs pour les données à transmettre à la JSP
        request.setAttribute("pageTitle", "Connexion");
        request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> erreurs = new ArrayList<>();
		
		if(!request.getParameter("identifiant").isEmpty()
				&& !request.getParameter("password").isEmpty()) {
			
			String identifiant = request.getParameter("identifiant");
			String password = request.getParameter("password");
			
			try {
				utilisateurManager.getInstance().login(identifiant, password);
				request.setAttribute("valide", "Vous êtes connecté !");
				response.sendRedirect("Profil");
				return;
			} catch (SQLException e) {
	            erreurs.add("L'identifiant ou le mot de passe est incorrect !");
	            e.printStackTrace();
	        } catch (Exception e) {
	            erreurs.add("Une erreur s'est produite lors de la création");
	            e.printStackTrace();
	        }
	    } else {
	        erreurs.add("Tous les champs doivent être remplis");
	    }
	}
}
