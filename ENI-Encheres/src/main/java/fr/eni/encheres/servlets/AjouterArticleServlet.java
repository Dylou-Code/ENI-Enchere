package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




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
        request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp").forward(request, response);
		
		try {
			 ArrayList<Categories> listCategories = new ArrayList<>();
			 listCategories.addAll(CategoriesManager.getInstance().SelectALL());
		        request.setAttribute("categories", listCategories);
		    } catch(Exception e) {
		        request.setAttribute("errorMessage", "Échec de la récupération des catégories");
		        e.printStackTrace();
		    }
		    
		    request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp").forward(request, response);
=======
		// TODO Auto-generated method stub
		request.setAttribute("pageTitle", "AjouterArticle");
        request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp").forward(request, response);
>>>>>>> d789c5144fa64f8864c0f1f4eaffb4b8a7a67f02
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//A faire
	}

}
