<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
      <ul class="nav-links">
        <li><a href="<%= request.getContextPath() %>/Connexion">Connexion</a></li>
        <li><a href="<%= request.getContextPath() %>/Inscription">S'inscrire</a></li>
         <li><a href="<%= request.getContextPath() %>/AjouterArticle">Article</a></li>
   
      </ul>
    </div>
  </nav>
	</header>
	
	
  
  <%-- A gérer--%>
  
   <%-- <c:if test="${empty User }">
		    	<div class="d-flex mx-3">
		    	<div class="mx-3 ">
		    		<a type="button" href="connexion" class="btn btn-outline-primary">Se connecter</a>
		    	</div>
		    		<a type="button" href="inscription" class="btn btn-primary">S'inscrire</a>
					 	
		    	</div>
	    </c:if> --%>
	
</body>
</html>