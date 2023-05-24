<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="../layout/navigation.jsp" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
   
   	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/navigation.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/reset.css">
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>


    
  <!-- c:set permet d'ajouter la variable content du "layout.jsp" qui est le layout général du projet-->
	<main class="main">
	     
		 <div class="container">
		 
		 <div class="title">
		 	<h1>Encheres</h1>
		 </div>
 			 
		<div class="filter-wrapper">
			<div class="filter">
				<div class="filter-categorie">
					<label for="categorie" class="filter-label">Catégories: </label>
					<select name="categories"  class="form-select" id="categorie-select">
					   <c:forEach var="categorie" items="${listCategorie}">
					    	<option id="searchCategorie" value="${categorie.id}" selected>${categorie.name.toUpperCase()}</option>
					    </c:forEach>
					</select>
				</div>
				<div class="Search">
					<div class="filter-search">
						<label for="categorie" class="filter-label">Filtres: </label>
						<input type="search" class="form-control" id="filtre-search" name="filtre-search">
						<button class="btn btn-primary">Rechercher</button>
					</div>
				
				</div>
				
			</div>

		</div>
		
		<div class="row row-cols-1 row-cols-md-4 g-4">
			<c:forEach var="article" items="${listesArticles }">
		  		<div class="col">
		    
		    
				
					<div class="card">
					    <div class="card-body">
					      <h5 class="card-title" > ${article.articleName }</h5>
					      <p class="card-text"> Prix : ${article.prixInitial }</p>
						    <div class="card-text">
						      <p class="text"> <span class="fw-bold">Fin de l'enchere : </span>${article.dateEndEnchere }</p>
						    </div>
						    
						     <a href="<%= request.getContextPath() %>/detailArticle" class="btn btn-primary">Encherir</a>
						     
						    
				    	</div>
				  	</div>
				  </div>
				</c:forEach>
		
		    
		  </div>
  
		</div>
		
	
		
		
		
		
		
		
		
		
			

		
	</main>
  <!-- Ajout du code de la page -->
   

	
	    	
</body>
</html>




