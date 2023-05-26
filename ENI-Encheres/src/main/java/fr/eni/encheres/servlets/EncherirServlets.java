package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticlesVenduManager;
import fr.eni.encheres.bll.EncheresManager;
import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.interfaces.EncheresDAO;

/**
 * Servlet implementation class EncheresServlets
 */
@WebServlet("/Encherir")
public class EncherirServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EncherirServlets() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("utilisateur") != null) {
			try {
				int idArticle = Integer.parseInt(request.getParameter("articleId"));
				ArticlesVendu article = ArticlesVenduManager.getInstance().SelectByIdArticle(idArticle);
				request.setAttribute("nomArticle", article.getArticleName());
				request.setAttribute("description", article.getDescription());
				request.setAttribute("categorie", article.getCategorie().getName());
				String txtMeilleureOffre = null;
				if (article.getPrixInitial() != article.getPrixVente()) {
					txtMeilleureOffre = article.getPrixVente() + " pts par " + article.getUtilisateur().getPseudo();
				}
				request.setAttribute("txtMeilleureOffre", txtMeilleureOffre);
				request.setAttribute("prixBase", article.getPrixInitial());
				LocalDate dateEndEnchere = article.getDateEndEnchere();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String dateFinFormatted = dateEndEnchere.format(formatter);
				request.setAttribute("dateFin", dateFinFormatted);
				request.setAttribute("retrait", article.getRetrait());
				request.setAttribute("vendeur", article.getUtilisateur().getPseudo());
				request.setAttribute("meilleureOffre", article.getPrixVente());
				request.setAttribute("hiddenIdArticle", idArticle);
				request.getRequestDispatcher("/WEB-INF/jsp/encherir.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/jsp/encherir.jsp").forward(request, response);

		} else {
			response.sendRedirect("Connexion");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("utilisateur") != null) {
			if (request.getParameter("btnEncherir") != null) {
				LocalDate date = LocalDate.parse(request.getParameter("dateFin"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				int montant = Integer.parseInt(request.getParameter("proposition"));
				int idArticle = Integer.parseInt(request.getParameter("hiddenIdArticle"));
				Utilisateurs util = (Utilisateurs) session.getAttribute("utilisateur");
				int idUser = util.getId();
				Encheres enchere = new Encheres(date, montant, idArticle, idUser);
				
				try {
					EncheresManager.getInstance().insert(enchere);
				} catch (Exception e) {
					e.printStackTrace();
				}
				response.sendRedirect("Encheres");
			}else {
				request.getRequestDispatcher("/WEB-INF/jsp/encherir.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("Connexion");
		} 
	}

}
