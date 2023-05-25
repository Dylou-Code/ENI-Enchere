<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
	
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/navigation.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>


<!-- CSS -->

<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath()%>/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath()%>/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>




	<!-- c:set permet d'ajouter la variable content du "layout.jsp" qui est le layout général du projet-->
	<main class="main">
	
	     
		 <div class="container">
		 
		 <div class="title">
		 	<h1>Listes des Encheres</h1>
		 </div>
		 
		 <c:if test="${not empty utilisateur}">
			      	<div class="filter-wrapper">
			<div class="filter">
				
				<div class="Search">
					<div class="search-item">
					<form action="" class="filter-search">
						<label for="categorie" class="filter-label">Filtres: </label>
						<input type="search" class="form-control" id="filtre-search" name="filtre-search" placeholder="Le nom de l'article contient">
						<button class="btn btn-primary search-btn">Rechercher</button>
					</form>
					</div>
				</div>
				
				<div class="filter-categorie">
					<label for="categorie" class="filter-label">Cat�gories: </label>
					<select name="categories"  class="form-select" id="categorie-select">
					   <c:forEach var="categorie" items="${listCategorie}">
					    	<option id="searchCategorie" value="${categorie.id}"selected>${categorie.name.toUpperCase()}</option>
					    </c:forEach>
					</select>
					
				</div>


		<div class="container">

			<div class="title">
				<h1>Listes des Encheres</h1>
			</div>

			<c:if test="${not empty utilisateur}">
				<div class="filter-wrapper">
					<div class="filter">

						<div class="Search">
							<div class="search-item">
								<form action="" class="filter-search">
									<label for="categorie" class="filter-label">Filtres: </label> <input
										type="search" class="form-control" id="filtre-search"
										name="filtre-search"
										placeholder="Le nom de l'article contient">
									<button class="btn btn-primary search-btn">Rechercher</button>
								</form>
							</div>
						</div>

						<div class="filter-categorie">
							<label for="categorie" class="filter-label">Catégories: </label>
							<select name="categories" class="form-select"
								id="categorie-select">
								<c:forEach var="categorie" items="${listCategorie}">
									<option id="searchCategorie" value="${categorie.id}" selected>${categorie.name.toUpperCase()}</option>
								</c:forEach>
							</select>
						</div>

					</div>
					<div class="filter-article">
						<div class="filter-article-item">
							<input type="radio" id="age1" name="age" value="30"> <label
								for="vente1" class="fw-bold">Achats</label><br> <input
								type=checkbox class="filter-article-choice" id="age1" name="age"
								value="30"> <label for="vente1">Encheres
								ouvertes</label><br> <input type="checkbox"
								class="filter-article-choice" id="age2" name="age" value="60">
							<label for="vente2">Mes enchères</label><br> <input
								type="checkbox" class="filter-article-choice" id="age3"
								name="age" value="100"> <label for="vente3">Mes
								enchères reportées</label><br>
							<br>
						</div>


						<div class="filter-article-item">
							<input type="radio" id="age1" name="age" value="30"> <label
								for="vente1" class="fw-bold">Mes ventes </label><br> <input
								type=checkbox name="vente" class="filter-article-choice"
								id="age1" name="age" value="30"> <label for="vente1">Mes
								ventes en cours</label><br> <input type="checkbox" name="vente"
								class="filter-article-choice" id="age2" name="age" value="60">
							<label for="vente2">Mes ventes non débutés</label><br> <input
								type="checkbox" name="vente" class="filter-article-choice"
								id="age3" name="age" value="100"> <label for="vente3">Ventes
								terminées</label><br>
							<br>
						</div>
					</div>

				</div>
			</c:if>

			<c:if test="${empty utilisateur}">
				<div class="filter-wrapper">
					<div class="filter">

						<div class="Search">
							<div class="search-item">
								<form action="" class="filter-search">
									<label for="categorie" class="filter-label">Filtres: </label> <input
										type="search" class="form-control" id="filtre-search"
										name="filtre-search"
										placeholder="Le nom de l'article contient">
									<button type="submit" class="btn btn-primary search-btn">Rechercher</button>
								</form>
							</div>
						</div>

						<div class="filter-categorie">
							<label for="categorie" class="filter-label">Catégories: </label>
							<select name="categories" class="form-select"
								id="categorie-select">
								<c:forEach var="categorie" items="${listCategorie}">
									<option id="searchCategorie" value="${categorie.id}" selected>${categorie.name.toUpperCase()}</option>
								</c:forEach>
							</select>
						</div>

					</div>
				</div>
		      </c:if> 
		      
		      
		      
 			 
		
		
		
		
		<div class="row row-cols-1 row-cols-md-4 g-4">
			<c:forEach var="article" items="${listesArticles }">
		  		<div class="col">
		    
		    
				
					<div class="card">
						<img src="<%= request.getContextPath()%>/img/Peugeot_208.jpg" class="card-img-top" alt="">
					    <div class="card-body">
					      <h5 class="card-title" > ${article.articleName }</h5>
					      <p class="card-text"> Prix : ${article.prixInitial }</p>
						    <div class="card-text">
						      <p class="text"> <span class="fw-bold">Fin de l'enchere : </span>${article.dateEndEnchere }</p>
						    </div>
						    
						   <a href="<%=request.getContextPath()%>/detailArticle?articleId=${article.no_article}" class="btn btn-primary">Voir plus</a>
						    
				    	</div>
				  	</div>
				  </div>
				</c:forEach>
				
				
		  </div>
		  
		  <div class="row row-cols-1 row-cols-md-4 g-4">
			<c:forEach var="enchere" items="${listeEncheres }">
		  		<div class="col">
		    
		    
				
					<div class="card">
					    <div class="card-body">
					      <h5 class="card-title" > ${enchere.id }</h5>
					      <p class="card-text"> Prix : ${enchere.price }</p>
						    <div class="card-text">
						      <p class="text"> <span class="fw-bold">Fin de l'enchere : </span>${enchere.date }</p>
						    </div>
						    
						     <a href="<%= request.getContextPath() %>/detailArticle" class="btn btn-primary">Encherir</a>
						    <%--  <a href="${request.contextPath}/detailArticle?articleId=${article.articleId}" class="btn btn-primary">D�tails</a>  --%>
						    
				    	</div>
				  	</div>
				  </div>
				</c:forEach>
				
				
		  </div>
  
		</div>
		
	</main>

			</c:if>

			<div class="row row-cols-1 row-cols-md-4 g-4">
				<c:forEach var="article" items="${listesArticles }">
					<div class="col">



						<div class="card">
							<img src="<%= request.getContextPath()%>/img/Audi_A3.jpg"
								class="card-img-top" alt="image voiture">
							<div class="card-body">
								<h5 class="card-title">${article.articleName }</h5>
								<p class="card-text">
									Prix : <span class="fw-bold">${article.prixInitial }</span>
								</p>
								<div class="card-text">
									<p class="text">
										Fin de l'enchere : <span class="fw-bold">${article.dateEndEnchere } </span></p>
								</div>

								<a href="<%= request.getContextPath() %>/detailArticle"
									class="btn btn-primary">Voir plus</a>
								<%--  <a href="${request.contextPath}/detailArticle?articleId=${article.articleId}" class="btn btn-primary">Détails</a>  --%>

							</div>
						</div>
					</div>
				</c:forEach>


			</div>

			<div class="row row-cols-1 row-cols-md-4 g-4">
				<c:forEach var="enchere" items="${listeEncheres }">
					<div class="col">



						<div class="card">
							<div class="card-body">
								<h5 class="card-title">${enchere.id }</h5>
								<p class="card-text">Prix : ${enchere.price }</p>
								<div class="card-text">
									<p class="text">
										Fin de l'enchere : <span class="fw-bold">${enchere.date }</span></p>
								</div>

								<a href="<%= request.getContextPath() %>/detailArticle"
									class="btn btn-primary">Encherir</a>
								<%--  <a href="${request.contextPath}/detailArticle?articleId=${article.articleId}" class="btn btn-primary">Détails</a>  --%>

							</div>
						</div>
					</div>
				</c:forEach>


			</div>

		</div>

	</main>

	<%@ include file="../layout/footer.jsp"%>

</body>
</html>




