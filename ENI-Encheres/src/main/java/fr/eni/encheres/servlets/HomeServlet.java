package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticlesVenduManager;
import fr.eni.encheres.bll.CategoriesManager;
import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.exceptions.DALException;

import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static ArticlesVenduManager articlevenduManager ; 
	private static CategoriesManager categorieManager;
	
	 static {
	
	    	articlevenduManager = new ArticlesVenduManager();
	    	categorieManager = new CategoriesManager();
	    	
	    }
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
  
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	
        // Récupérer la liste des articles dont la vente est en cours 
      
        List<ArticlesVendu> listesArticles = new ArrayList<ArticlesVendu>();;
		try {
			listesArticles = ArticlesVenduManager.getInstance().SelectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("listesArticles", listesArticles);
       
        List<Categories> listCategorie = new ArrayList<Categories>();
        listCategorie.add(new Categories(0, "Toutes"));
        
        try {
        	
            listCategorie.addAll(categorieManager.SelectALL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        request.setAttribute("listCategorie", listCategorie);
        request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp").forward(request, response);
    
    }

}
