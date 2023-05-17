package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
