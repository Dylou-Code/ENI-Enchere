<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ENI-ENCHERE</title>
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/layout.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/reset.css">
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>

<body>
	<%@ include file="../layout/navigation.jsp" %>
	<!-- Permet d'ajouter le code de la navigation-->
	
	
	
	<!-- Va permettre de contenir toutes nos pages-->
	<div class="container">
	
		<jsp:include page="${content}" />
	</div>
	
	<!-- Ajouter ce code dans les différentes pages
	<c:set var="content">
    <div class="container">
    	<p>Exemple</p>
        <h1>Accueil</h1>
        <p>Bienvenue sur notre application d'enchères !</p>
        
    </div>
</c:set>-->
	
</body>
</html>
