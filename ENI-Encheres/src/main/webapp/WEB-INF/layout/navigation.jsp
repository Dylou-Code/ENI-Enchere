<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/navigation.css">
<title>ENI-ENCHERES</title>
</head>
<body>
<header>
  <nav>    
	    <div class="nav-content">
	      <div class="logo">
	        <a href="<%= request.getContextPath() %>/">ENI-ENCHERES</a>
	      </div>
	      
	      <c:if test="${not empty utilisateur}">
	      	<ul class="nav-links">
		        <li><a href="<%= request.getContextPath() %>/Encheres">Enchères</a></li>
		        <li><a href="<%= request.getContextPath() %>/AjouterArticle">Vendre un article</a></li>
		        <li><a href="<%= request.getContextPath() %>/MonProfil">Mon profil</a></li>
		        <li><a href="<%= request.getContextPath() %>/Deconnexion">Se déconnecter</a></li>
	      	</ul>
	      </c:if>
	      
	      <c:if test="${empty utilisateur}">
	      	  <ul class="nav-links">
		        <li><a href="<%= request.getContextPath() %>/Connexion">Connexion</a></li>
		        <li><a href="<%= request.getContextPath() %>/Inscription">S'inscrire</a></li>
		      </ul>
	      </c:if>

		</div>
  	</nav>
</header>
</body>
</html>