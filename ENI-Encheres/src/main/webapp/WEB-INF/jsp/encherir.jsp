<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <jsp:include page="../layout/layoutConnecte.jsp" /> --%>
<jsp:include page="../layout/navigation.jsp" />
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

<!-- Ajouter ce code dans les différentes pages-->
<style>
.title {
	text-align: center;
}

.form-container {
	display: grid;
	grid-template-columns: auto 1fr;
	grid-gap: 10px;
	align-items: center;
	justify-content: center;
}

.image-container {
	display: flex;
	align-items: flex-start;
	justify-content: flex-start;
}

.image-container img {
	max-width: 500px;
	margin-bottom: 55%;
	margin-left: -40%;
}

.mb-6 {
	display: flex;
	align-items: center;
}

.form-label {
	text-align: left;
	margin-right: 70px;
	width: 200px;
}

.input-container {
	display: flex;
	align-items: center;
}

.small-input {
	margin-left: -7%;
	width: 100px;
	border: 2px solid black; border-radius : 5px;
	margin-right: 5%;
	border-radius: 5px;
}

.form-control {
  border: none;
  background-color: transparent;
  padding: 0;
  box-shadow: none;
  caret-color: transparent;
}

.form-control[readonly] {
  border: none;
  background-color: transparent;
  padding: 0;
  box-shadow: none;
  caret-color: transparent;
}
</style>

	<div class="container">

		<div class="Title">
			<h2>Détail Vente</h2>
		</div>

		<div class="container">
			<h1 class="title">${titre}</h1>
		<form method="POST"
				action="<%=request.getContextPath()%>/Encherir?articleId=${hiddenIdArticle}">
			<div class="form-container">
				<div class="image-container">
					<img src="<%=request.getContextPath()%>/img/Peugeot_208.jpg"
						class="card-img-top" alt="">
				</div>

				<div class="form-content">
						<div class="mb-6">
							<input type="text" id="nomArticle" class="form-control" value="${nomArticle}" name="nomArticle" readonly>
						</div>

						<div class="mb-6">
							<label for="OutPutDescription" class="form-label">Description :</label> 
							<input type="text" id="OutPutDescription" class="form-control" value="${description}" name="description" readonly>
						</div>

						<div class="mb-6">
							<label for="OutPutCategorie" class="form-label">Catégorie :</label> 
							<input type="text" id="OutPutCategorie" class="form-control" value="${categorie}" name="categorie" readonly>
						</div>

						<div class="mb-6">
							<label for="OutPutMeilleureOffre" class="form-label">Meilleure offre :</label> 
							<input type="text" id="OutPutMeilleureOffre" class="form-control" value="${txtMeilleureOffre}" name="txtMeilleureOffre" readonly>
						</div>

						<div class="mb-6">
							<label for="OutPutPrixInitial" class="form-label">Mise à prix :</label> 
							<input type="text" id="OutPutPrixInitial" class="form-control" value="${prixBase}" name="prixBase" readonly>
						</div>
						
						<div class="mb-6">
							<label for="OutPutDateFin" class="form-label">Fin de l'enchère :</label> 
							<input type="text" id="OutPutDateFin" class="form-control" name="dateFin" value="${dateFin}" readonly>
						</div>

						<div class="mb-6">
							<label for="OutPutRetrait" class="form-label">Retrait :</label> 
							<input type="text" id="OutPutRetrait" class="form-control" value="${retrait}" name="retrait" readonly>
						</div>

						<div class="mb-6">
							<label for="OutPutVendeur" class="form-label">Vendeur :</label> 
							<input type="text" id="OutPutVendeur" class="form-control" value="${vendeur}" name="vendeur" readonly>
						</div>
					
					<div class="mb-6 input-container">
						<label for="proposition" class="form-label">Ma proposition :</label> 
						<input type="number" class="small-input" aria-label="price" name="proposition" value="${meilleureOffre}" min="${meilleureOffre}" step="1" required>
						<button type="submit" class="btn btn-success" name="btnEncherir">Encherir</button>
					</div>

					<input type="hidden" name="hiddenIdArticle" value="${hiddenIdArticle}">
				</div>
			</div>
			</form>
		</div>
		

</body>
</html>


<!-- Gestion erreurs des champs
			<c:if test="${not empty erreur }">
				<div class="alert alert-danger text-center" role="alert">
					<c:out value="${erreur}"></c:out>
				</div>
			</c:if>-->