package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MonProfil")
public class MonProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MonProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    
	    if (session != null && session.getAttribute("utilisateur") != null) {
	    	request.getRequestDispatcher("/WEB-INF/jsp/monProfil.jsp").forward(request, response);
	    } else {
	        response.sendRedirect("Connexion");
	    }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}