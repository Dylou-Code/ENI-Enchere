<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:include page="../layout/layout.jsp" />

<!-- Ajouter ce code dans les différentes pages-->
	<c:set var="content">
    <div class="container">
    	<form class="row g-3" action="<%= request.getContextPath()%>/Inscription" method="POST">
	    	<div class="col-md-6">
		    	<label for="inputEmail4" class="form-label">Pseudo :</label>
		    	<input type="text" class="form-control" id="inputEmail4" name="pseudo" value="" required>
		  	</div>
		  
			  <div class="col-md-6">
			    <label for="inputPassword4" class="form-label">Nom :</label>
			    <input type="text" class="form-control" id="inputPassword4" name="lastName" required>
			  </div>
			  
			  <div class="col-md-6">
			    <label for="inputAddress" class="form-label">Prénom :</label>
			    <input type="text" class="form-control" id="inputAddress" name="firstName" required>
			  </div>
			  
			  <div class="col-md-6">
			    <label for="inputCity" class="form-label">Email :</label>
			    <input type="email" class="form-control" id="inputCity" name="email" required>
			  </div>
			  
			   <div class="col-md-6">
			    <label for="inputCity" class="form-label">Téléphone :</label>
			    <input type="text" class="form-control" id="inputCity" name="phoneNumber" required>
			  </div>
			  
			   <div class="col-md-6">
			    <label for="inputCity" class="form-label">Rue :</label>
			    <input type="text" class="form-control" id="inputCity" name="street" required>
			  </div>
			  
			   <div class="col-md-6">
			    <label for="inputCity" class="form-label">Code Postal :</label>
			    <input type="text" class="form-control" id="inputCity" name="zipCode" required>
			  </div>
			 
			  <div class="col-md-6">
			    <label for="inputZip" class="form-label">Ville :</label>
			    <input type="text" class="form-control" id="inputZip" name="city" required>
			  </div>
			  
			  <div class="col-md-6">
			    <label for="inputZip" class="form-label">Mot de passe actuel :</label>
			    <input type="password" class="form-control" id="password" name="password" required>
			  </div>
			  
			  <div class="col-md-6">
			    <label for="confirm" class="form-label">Nouveau mot de passe :</label>
			    <input type="password" class="form-control" id="newPassword" name="newPassword" required>
			  </div>
			  
			  <div class="col-md-6">
			    <label for="confirm" class="form-label">Nouveau mot de passe :</label>
			    <input type="password" class="form-control" id="confirmNewPassword" name="confirmNewPassword" required>
			  </div>
			  
			  <div class="col-md-">
		  	  </div>
			  
			  <div class="col-md-6">
			    <label for="inputZip" class="form-label">Crédit :</label>
			    <input type="text" style="border: none; padding: 0; margin: 0;" class="form-control" id="inputCredit" name="credit" required>
			  </div>
			  
	    	  <div class="col-md-">
		  	  </div>
		  	  
	    	  <div style="text-align: center">
		    	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			    	<button type="submit" class="btn btn-primary me-md-2">Enregistrer les modifications</button>
			    	<button type="submit" class="btn btn-primary">Supprimer mon compte</button>
		    	</div>
			 </div>
	    </form>
	</div>
</c:set>