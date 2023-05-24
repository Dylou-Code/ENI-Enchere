package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticlesVenduManager;
import fr.eni.encheres.bll.CategoriesManager;
import fr.eni.encheres.bll.RetraitsManager;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.bo.Retraits;



/**
 * Servlet implementation class AjouterArticleServlet
 */
@WebServlet("/AjouterArticle")
public class AjouterArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session user à rajouter dans la condition 
		
		
		//ArrayList<Categories> listCategories = new ArrayList<>();
		//Récuperation catégorie
		/*try {
			listCategories.addAll(CategoriesManager.getInstance().SelectALL());
		} catch(Exception e){
			request.setAttribute("message", "Echec de l'ajout");
			e.printStackTrace();
		}
	
		
		request.setAttribute("pageTitle", "AjouterArticle");
        request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp").forward(request, response);*/
		
		try {
			 ArrayList<Categories> listCategories = new ArrayList<>();
			 listCategories.addAll(CategoriesManager.getInstance().SelectALL());
		        request.setAttribute("categories", listCategories);
		    } catch(Exception e) {
		        request.setAttribute("errorMessage", "Échec de la récupération des catégories");
		        e.printStackTrace();
		    }
		    
		    request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//A faire
		if(!request.getParameter("articleName").isEmpty()
    			&& !request.getParameter("description").isEmpty() 
    			//&& !request.getParameter("categories").isEmpty() 
    			//&& !request.getParameter("image").isEmpty() 
    			&& !request.getParameter("prixInitial").isEmpty()
    			&& !request.getParameter("dateStartEnchere").isEmpty()
    			&& !request.getParameter("dateEndEnchere").isEmpty()
    			&& !request.getParameter("street").isEmpty()
    			&& !request.getParameter("city").isEmpty()) {
			
			//gestion date 
			LocalDate Debut = LocalDate.parse(request.getParameter("dateStartEnchere"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			LocalDate Fin = LocalDate.parse(request.getParameter("dateEndEnchere"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			
			//creation de l'article
			ArticlesVendu Article = new ArticlesVendu(0, request.getParameter("article"), request.getParameter("description"), 
					Debut, Fin, Integer.parseInt(request.getParameter("prixInitial")), 0, null);
			
			try {
				ArticlesVenduManager.getInstance().ajouterArticle(Article);
				Retraits Retrait = new Retraits(Article, request.getParameter("street"),request.getParameter("zipCode"),
						request.getParameter("city")) ;
				//appel instance et créer ajout retraits
				RetraitsManager.getInstance().ajouterRetraits(Retrait);
				
				request.setAttribute("valide", "La vente à bien été crée");
			} catch(Exception e) {
				
			}
		}
    			
		
	}

}
