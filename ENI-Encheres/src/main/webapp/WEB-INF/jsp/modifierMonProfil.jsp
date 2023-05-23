<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:include page="../layout/layout.jsp" />

<!-- Ajouter ce code dans les différentes pages-->
	<c:set var="content">
    <div class="container">
    	<form class="row g-3" action="<%= request.getContextPath()%>/Inscription" method="POST">
	    	<div class="col-md-6">
		    	<label for="inputEmail4" class="form-label">Pseudo :</label>
		    	<input type="text" class="form-control" id="pseudo" name="pseudo" value="${utilisateur.pseudo}">
		  	</div>
		  
			  <div class="col-md-6">
			    <label for="inputPassword4" class="form-label">Nom :</label>
			    <input type="text" class="form-control" id="lastName" name="lastName" value="${utilisateur.lastName}">
			  </div>
			  
			  <div class="col-md-6">
			    <label for="inputAddress" class="form-label">Prénom :</label>
			    <input type="text" class="form-control" id="firstName" name="firstName" value="${utilisateur.firstName}">
			  </div>
			  
			  <div class="col-md-6">
			    <label for="inputCity" class="form-label">Email :</label>
			    <input type="email" class="form-control" id="email" name="email" value="${utilisateur.email}">
			  </div>
			  
			   <div class="col-md-6">
			    <label for="inputCity" class="form-label">Téléphone :</label>
			    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${utilisateur.phoneNumber}">
			  </div>
			  
			   <div class="col-md-6">
			    <label for="inputCity" class="form-label">Rue :</label>
			    <input type="text" class="form-control" id="street" name="street" value="${utilisateur.street}">
			  </div>
			  
			   <div class="col-md-6">
			    <label for="inputCity" class="form-label">Code Postal :</label>
			    <input type="text" class="form-control" id="zipCode" name="zipCode" value="${utilisateur.street}">
			  </div>
			 
			  <div class="col-md-6">
			    <label for="inputZip" class="form-label">Ville :</label>
			    <input type="text" class="form-control" id="city" name="city" value="${utilisateur.city}">
			  </div>
			  
			  <div class="col-md-6">
			    <label for="password" class="form-label">Mot de passe actuel :</label>
			    <input type="password" class="form-control" id="password" name="password">
			  </div>
			  
			  <div class="col-md-6">
		  	  </div>
			  
			  <div class="col-md-6">
			    <label for="newPassword" class="form-label">Nouveau mot de passe :</label>
			    <input type="password" class="form-control" id="newPassword" name="newPassword">
			  </div>
			  
			  <div class="col-md-6">
			    <label for="confirm" class="form-label">Confirmer nouveau mot de passe :</label>
			    <input type="password" class="form-control" id="confirmNewPassword" name="confirmNewPassword">
			  </div>
			  
			  <div class="col-md-">
		  	  </div>
			  
			  <div class="col-md-6">
			    <label for="credit" class="form-label">Crédit :</label>
			    <p>${utilisateur.credit}</p>
			  </div>
			  
	    	  <div class="col-md-">
		  	  </div>
		  	  
	    	  <div style="text-align: center">
		    	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			    	<button type="submit" class="btn btn-primary me-md-2" onclick="enregistrerModifications()">Enregistrer les modifications</button>
			    	<button type="submit" class="btn btn-primary" onclick="supprimerCompte()">Supprimer mon compte</button>
		    	</div>
			 </div>
	    </form>
	</div>
</c:set>