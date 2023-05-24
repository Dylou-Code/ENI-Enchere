<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="../layout/layout.jsp" />

  <!-- c:set permet d'ajouter la variable content du "layout.jsp" qui est le layout général du projet-->
  <c:set var="content">
  <!-- Ajout du code de la page -->
    <div class="container">
       <h3>Listes enchères</h3>
	
	<label for="site-search">Filtres:</label>
		<input type="search" id="site-search" name="q">
		
		<button class="btn btn-primary">Search</button>
			<br>
			<label for="categories">Catégories</label>
			<br>
		
		<select name="categorie" id="categorie-select">
		    <option value="">Toutes</option>
		    
		</select>
		
		<br>
		
		<div class="card" style="width: 18rem;">
		  <img src="..." class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title">PC Gamer</h5>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
		    <a href="#" class="btn btn-primary">Go somewhere</a>
		  </div>
		</div>
			
    </div>
</c:set>
	
	




