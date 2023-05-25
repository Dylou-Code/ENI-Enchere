<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/navigation.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un article</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/layout.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>

	<!-- c:set permet d'ajouter la variable content du "layout.jsp" qui est le layout général du projet-->

	<!-- Ajout du code de la page -->

	<main>
		<div class="container">

			<div class="Title">
				<h2>Nouvelle Vente</h2>
			</div>
			<form method="POST"
				action="<%=request.getContextPath()%>/AjouterArticle">
				<div class="mb-3">
					<label for="articleName" class="form-label">Article : </label> <input
						type="text" class="form-control" id="articleName"
						name="articleName" required>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">Description</label>
					<textarea class="form-control" id="exampleFormControlTextarea1"
						rows="3" name="description" required></textarea>
				</div>
				<!-- gerer récupération des catégorie(boucle forEach) -->
				<div>
					<label for="categorie" class="filter-label">Catégories: </label> 
					<select name="categories" class="form-select" id="categorie-select">
						<c:forEach var="categorie" items="${listCategorie}">
							<option id="searchCategorie" value="${categorie.id}" selected>${categorie.name.toUpperCase()}</option>
						</c:forEach>
					</select>
				</div>

				<br>
				<!-- <div class="mb-3">
	  	 <p></p>
	    <input type="file" class="form-control" aria-label="file example"  name="image" disabled >
	    <div class="invalid-feedback">Example invalid form file feedback</div>
	  </div> -->

				<div class="mb-3">
					<label for="price" class="form-label">Mise à prix</label> <input
						type="number" class="form-control" aria-label="price"
						name="prixInitial" required>
				</div>

				<div class="mb-3">
					<p>Début enchère</p>
					<input type="date" class="form-control" aria-label="date"
						name="dateStartEnchere" required>
				</div>
				<br>
				<div class="mb-3">
					<p>Fin enchère</p>
					<input type="date" class="form-control" aria-label="date"
						name="dateEndEnchere" required>
				</div>

				<fieldset>
					<legend>Retrait</legend>
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Rue</label>
						<input type="text" class="form-control" id="street" name="street" value="${utilisateur.street}">
					</div>

					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Code
							Postal</label> <input type="text" class="form-control" id="zipCode"
							name="zipCode" value="${utilisateur.zipCode}">
					</div>

					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Ville</label>
						<input type="text" class="form-control" id="city" name="city" value="${utilisateur.city}">
					</div>
				</fieldset>

				<div class="d-grid gap-5 d-md-block">
					<button class="btn btn-primary" type="submit">Enregistrer</button>
					<button class="btn btn-danger" type="submit"
						onclick="cancel(event)">Annuler</button>
				</div>
			</form>

		</div>

	</main>

	<script>
		function cancel(event) {
			event.preventDefault();
			window.location.href = "http://localhost:8080/ENI-Encheres/";
		}
	</script>

</body>
</html>
