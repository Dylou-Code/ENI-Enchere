<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%-- <jsp:include page="../layout/layoutConnecte.jsp" /> --%>
<jsp:include page="../layout/layout.jsp" />

<!-- Ajouter ce code dans les différentes pages-->
	<c:set var="content">
    <div class="container">

		  <fieldset disabled>
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Catégorie :</label>
		      <input type="text" id="categorie" class="form-control" value="${categorie}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Nom :</label>
		      <input type="text" id="OutPutNom" class="form-control" value="${nom}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Prénom :</label>
		      <input type="text" id="OutPutPrenom" class="form-control" value="${prenom}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Email :</label>
		      <input type="text" id="OutPutEmail" class="form-control" value="${email}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Téléphone :</label>
		      <input type="text" id="OutPutTelephone" class="form-control" value="${telephone}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Rue :</label>
		      <input type="text" id="OutPutRue" class="form-control" value="${rue}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Code Postal :</label>
		      <input type="text" id="OutPutZip" class="form-control" value="${code_postal}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Ville :</label>
		      <input type="text" id="OutPutVille" class="form-control" value="${ville}">
		    </div>
		    <br>
		  </fieldset>
		<form action="<%= request.getContextPath() %>/ModifierMonProfil" method="post">
        	<button type="submit" class="btn btn-primary">Modifier mon profil</button>
    	</form>
    </div>
</c:set>
	<!-- <section class="main">
		<div class="title">
		 		<h1>Details vente</h1>
		 	</div> -->
	<!-- 	<div class="container">
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
			</div> -->
		
		
			<!-- Gestion erreurs des champs
			<c:if test="${not empty erreur }">
				<div class="alert alert-danger text-center" role="alert">
					<c:out value="${erreur}"></c:out>
				</div>
			</c:if>-->