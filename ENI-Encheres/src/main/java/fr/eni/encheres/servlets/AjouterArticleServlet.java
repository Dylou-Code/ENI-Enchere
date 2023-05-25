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
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.transport.ReplicationTransmitter;

import fr.eni.encheres.bll.ArticlesVenduManager;
import fr.eni.encheres.bll.CategoriesManager;
import fr.eni.encheres.bll.RetraitsManager;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.exceptions.DALException;



/**
 * Servlet implementation class AjouterArticleServlet
 */
@WebServlet("/AjouterArticle")
public class AjouterArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ArticlesVenduManager articlevenduManager ; 
	private static CategoriesManager categorieManager;

	static {

		articlevenduManager = new ArticlesVenduManager();
		categorieManager = new CategoriesManager();

	}

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

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("utilisateur") != null) {
			List<Categories> listCategorie = new ArrayList<Categories>();
			listCategorie.add(new Categories(0, null));

			try {

				listCategorie.addAll(categorieManager.SelectALL());
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("listCategorie", listCategorie);
			request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticle.jsp").forward(request, response);
		} else {
			request.setAttribute("pageTitle", "Connexion");
			request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("utilisateur") != null) {
			Utilisateurs util = (Utilisateurs) session.getAttribute("utilisateur");
			int idCategorie = Integer.parseInt(request.getParameter("categories"));
			Categories categorie = null;
			try {
				categorie = categorieManager.SelectById(idCategorie);
			} catch (DALException e) {
				e.printStackTrace();
			}
			String article = request.getParameter("articleName");
			String description = request.getParameter("description");
			int prix = Integer.parseInt(request.getParameter("prixInitial"));
			LocalDate Debut = LocalDate.parse(request.getParameter("dateStartEnchere"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			LocalDate Fin = LocalDate.parse(request.getParameter("dateEndEnchere"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String rue = request.getParameter("street");
			String codePostal = request.getParameter("zipCode");
			String ville = request.getParameter("city");
			//creation de l'article
			ArticlesVendu Article = new ArticlesVendu(article, description, Debut, Fin, prix, util, categorie);
			try {
				articlevenduManager.getInstance().ajouterArticle(Article);
				int idArticle = articlevenduManager.getInstance().selectLastInsertId();
				Article.setNo_article(idArticle);
				Retraits Retrait = new Retraits(Article, rue, codePostal, ville);
				RetraitsManager.getInstance().ajouterRetraits(Retrait);
				request.setAttribute("valide", "La vente a bien été crée");
				response.sendRedirect("http://localhost:8080/ENI-Encheres/");
			} catch(Exception e) {

			}
		}
	}


}
