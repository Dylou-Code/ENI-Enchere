package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticlesVenduManager;
import fr.eni.encheres.bll.RetraitsManager;
import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.bo.Utilisateurs;

/**
 * Servlet implementation class DetailArticle
 */
@WebServlet("/detailArticle")
public class DetailArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
	    
	    if (session != null && session.getAttribute("utilisateur") != null) {
	    	int idArticle = Integer.parseInt(request.getParameter("articleId"));
	    	try {
				ArticlesVendu article = ArticlesVenduManager.getInstance().SelectByIdArticle(idArticle);
				request.setAttribute("categorie", article.getCategorie().getName());
				request.setAttribute("nom", article.getUtilisateur().getLastName());
				request.setAttribute("prenom", article.getUtilisateur().getFirstName());
				request.setAttribute("email", article.getUtilisateur().getEmail());
				request.setAttribute("telephone", article.getUtilisateur().getPhoneNumber());
				request.setAttribute("rue", article.getRetrait().getStreet());
				request.setAttribute("code_postal", article.getRetrait().getZipCode());
				request.setAttribute("ville", article.getRetrait().getCity());
				request.setAttribute("idArticle", article.getNo_article());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
			request.getRequestDispatcher("/WEB-INF/jsp/detailArticle.jsp").forward(request, response);
	    } else {
	    	request.setAttribute("pageTitle", "Connexion");
	        request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
