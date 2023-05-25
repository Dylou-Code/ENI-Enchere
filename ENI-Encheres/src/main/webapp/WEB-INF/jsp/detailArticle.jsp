<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
     <%@ include file="../layout/navigation.jsp" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
   
   	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/navigation.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/reset.css">
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<title></title>
</head>
<body>


	<section class="main">
		<div class="title">
		 		<h1>Details vente</h1>
		 	</div>
		<div class="container">
			<div class="details">
				<h3>Titre de l'article Vendu</h3>
				<p class="text-description">Description :</p>
				<p>Catégorie :</p>
				<p>Meilleure offre :</p>
				<p>Mise à prix :</p>
				<p>Fin de l'enchère : </p>
				<p>Retrait :</p>
				<p>Vendeur :</p>
				<p>Vendeur :  </p>
				
				<button type="submit" class="btn btn-success">Encherir</button>
			</div>
		
		
			<!-- Gestion erreurs des champs
			<c:if test="${not empty erreur }">
				<div class="alert alert-danger text-center" role="alert">
					<c:out value="${erreur}"></c:out>
				</div>
			</c:if>-->
		
		</div>
	
	</section>
	
	
</body>
</html>