package fr.eni.encheres.servlets;

import java.io.IOException;
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

		/*if (session != null && session.getAttribute("utilisateur") != null) {

    		request.getRequestDispatcher("/WEB-INF/jsp/modifierMonProfil.jsp").forward(request, response);

    	} else {

    	 response.sendRedirect("Connexion");

     }*/
		/*if (utilisateurConnecte != null) {
            // L'utilisateur est connecté, afficher les articles de l'utilisateur
            List<Article> articlesUtilisateur = getArticlesUtilisateur(utilisateurConnecte.getId());
            request.setAttribute("listesArticles", articlesUtilisateur);
        } else {
            // L'utilisateur n'est pas connecté, afficher tous les articles
            List<Article> tousLesArticles = getAllArticles();
            request.setAttribute("listesArticles", tousLesArticles);
        }

        // Autres traitements ou redirection vers la JSP appropriée
        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }
    	if(request.getSession().getAttribute("User") == null) {}*/


		// Récupérer la liste des articles dont la vente est en cours 
		


		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("utilisateur") != null)  {
			Utilisateurs util = (Utilisateurs) session.getAttribute("utilisateur");
			int id = util.getId();
			try {
//				List<Encheres> listeEncheres = EncheresManager.getInstance().getAllAuctionByUser(id);
//				
//				request.setAttribute("listesEncheres", listeEncheres);
				
				

				List<Categories> listCategorie = new ArrayList<Categories>();
				listCategorie.add(new Categories(0, "Toutes"));

				try {

					listCategorie.addAll(categorieManager.SelectALL());
				} catch (Exception e) {
					e.printStackTrace();
				}

				request.setAttribute("listCategorie", listCategorie);
				request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp").forward(request, response);
				
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
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

}
