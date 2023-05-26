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

import fr.eni.encheres.bll.ArticlesVenduManager;
import fr.eni.encheres.bll.CategoriesManager;
import fr.eni.encheres.bll.EncheresManager;
import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Utilisateurs;

/**
 * Servlet implementation class EncheresServlets
 */
@WebServlet("/Encheres")
public class EncheresServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncheresServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("utilisateur") != null)  {
			Utilisateurs util = (Utilisateurs) session.getAttribute("utilisateur");
			int idUser = util.getId();
			try {
				
				List<Encheres> listeEncheres = EncheresManager.getInstance().getAllAuctionByUser(idUser);
				request.setAttribute("listesEncheres", listeEncheres);
				
				List<ArticlesVendu> listeArticles = ArticlesVenduManager.getInstance().SelectAll();
				request.setAttribute("listeArticles", listeArticles);
				request.getRequestDispatcher("/WEB-INF/jsp/enchere.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("Connexion");
		}

	}


}
