<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:include page="../layout/layout.jsp" />

<!-- Ajouter ce code dans les différentes pages-->
	<c:set var="content">
    <div class="container">
    
    	<div class="col-md-6">
	    	<label for="inputEmail4" class="form-label">Pseudo</label>
	    	<input type="text" class="form-control" id="inputEmail4" name="pseudo" value="" required>
	  	</div>
	  
		  <div class="col-md-6">
		    <label for="inputPassword4" class="form-label">Nom</label>
		    <input type="text" class="form-control" id="inputPassword4" name="lastName" required>
		  </div>
		  
		  <div class="col-md-6">
		    <label for="inputAddress" class="form-label">Prénom</label>
		    <input type="text" class="form-control" id="inputAddress" name="firstName" required>
		  </div>
		  
		  <div class="col-md-6">
		    <label for="inputCity" class="form-label">Email</label>
		    <input type="email" class="form-control" id="inputCity" name="email" required>
		  </div>
		  
		   <div class="col-md-6">
		    <label for="inputCity" class="form-label">Telephone</label>
		    <input type="text" class="form-control" id="inputCity" name="phoneNumber" required>
		  </div>
		  
		   <div class="col-md-6">
		    <label for="inputCity" class="form-label">Rue</label>
		    <input type="text" class="form-control" id="inputCity" name="street" required>
		  </div>
		  
		   <div class="col-md-6">
		    <label for="inputCity" class="form-label">Code Postal</label>
		    <input type="text" class="form-control" id="inputCity" name="zipCode" required>
		  </div>
		 
		  <div class="col-md-6">
		    <label for="inputZip" class="form-label">Ville</label>
		    <input type="text" class="form-control" id="inputZip" name="city" required>
		  </div>
    	
    	<button type="submit" class="btn btn-primary">Modifier mon profil</button>
    </div>
</c:set>