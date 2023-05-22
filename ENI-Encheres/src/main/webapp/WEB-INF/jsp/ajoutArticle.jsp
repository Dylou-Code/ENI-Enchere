<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ include file="../layout/navigation.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un article</title>
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/layout.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/reset.css">
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
    
  <!-- c:set permet d'ajouter la variable content du "layout.jsp" qui est le layout général du projet-->

  <!-- Ajout du code de la page -->
    
    	<div class="Title">
    		 <h2>Nouvelle Vente</h2>
    	</div>
    	<form  method="POST" action="<%= request.getContextPath()%>/AjouterArticle">
    		<div class="mb-3">
  			<label for="articleName" class="form-label">Article : </label>
 			 <input type="email" class="form-control" id="articleName" name="articleName">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">Description</label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"  name="description"></textarea>
		</div>
		<!-- gerer récupération des catégorie(boucle forEach) -->
		<label for="Categories" class="form-label">Catégories</label>
		<select class="form-select" aria-label="categories"  name="categories"  >
		  <option selected value="">Sélectionnez</option>
		 
		<%--   <c:forEach items="" >
		  	 <option value="${ nom.no_categorie }"><c:out value="${ nom.libelle }"/></option>
		  </c:forEach> --%>
		  
		  	<%-- <c:forEach items="${categories}" var="category">
			    <option value="${category.no_categorie}">
			      <c:out value="${category.libelle}" />
			    </option>
  			</c:forEach> --%>
  			
  			<c:forEach var="category" items="${requestScope.categories}">
                <option value="${category.no_categorie}">
                    <c:out value="${category.libelle}" />
                </option>
            </c:forEach>
		</select>
		
		<br>
	  <div class="mb-3">
	  	 <p></p>
	    <input type="file" class="form-control" aria-label="file example"  name="image" disabled >
	    <div class="invalid-feedback">Example invalid form file feedback</div>
	  </div>
	  
	  <div class="mb-3">
	  	<label for="price" class="form-label">Mise à prix</label>
	    <input type="number" class="form-control" aria-label="price"  name="prixInitial" required>
	  </div>
	  
	   <div class="mb-3">
	   <p>Début enchère</p>
	    <input type="date" class="form-control" aria-label="date"  name="dateStartEnchere" required>
	  </div>
	  <br>
	  <div class="mb-3">
	   <p>Fin enchère</p>
	    <input type="date" class="form-control" aria-label="date"  name="dateEndEnchere" required>
	  </div>
		
	<fieldset>
	    <legend>Retrait</legend>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label" value="${ categories.libelle}" >Rue</label>
 			 <input type="text" class="form-control" id="street" name="street" >
		</div>
	
	   <div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">Code Postal</label>
 			 <input type="text" class="form-control" id="zipCode" name="zipCode">
		</div>
		
		<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">Ville</label>
 			 <input type="text" class="form-control" id="city" name="city">
		</div>
	</fieldset>
	
	<div class="d-grid gap-5 d-md-block">
	  <button class="btn btn-primary" type="submit">Enregistrer</button>
	  <button class="btn btn-primary" type="annuler">Annuler</button>
	</div>	
    	</form>
    	
</body>
</html>
	