<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:include page="../layout/layout.jsp" />

<!-- Ajouter ce code dans les différentes pages-->
	<c:set var="content">
    	<div class="container">

		    	<form>
				  <fieldset disabled>
				    <div class="mb-6">
				      <label for="disabledTextInput" class="form-label">Pseudo</label>
				      <input type="text" id="OutPutPseudo" class="form-control" placeholder="Recup pseudo">
				    </div>
				    
				    <div class="mb-6">
				      <label for="disabledTextInput" class="form-label">Nom</label>
				      <input type="text" id="OutPutNom" class="form-control" placeholder="Recup nom">
				    </div>
				    
				    <div class="mb-6">
				      <label for="disabledTextInput" class="form-label">Prenom</label>
				      <input type="text" id="OutPutPrenom" class="form-control" placeholder="Recup prenom">
				    </div>
				    
				    <div class="mb-6">
				      <label for="disabledTextInput" class="form-label">Email</label>
				      <input type="text" id="OutPutEmail" class="form-control" placeholder="Recup email">
				    </div>
				    
				    <div class="mb-6">
				      <label for="disabledTextInput" class="form-label">Telephone</label>
				      <input type="text" id="OutPutTelephone" class="form-control" placeholder="Recup telephone">
				    </div>
				    
				    <div class="mb-6">
				      <label for="disabledTextInput" class="form-label">Rue</label>
				      <input type="text" id="OutPutRue" class="form-control" placeholder="Recup rue">
				    </div>
				    
				    <div class="mb-6">
				      <label for="disabledTextInput" class="form-label">Code Postal</label>
				      <input type="text" id="OutPutZip" class="form-control" placeholder="Recup zip">
				    </div>
				    
				    <div class="mb-6">
				      <label for="disabledTextInput" class="form-label">Ville</label>
				      <input type="text" id="OutPutVille" class="form-control" placeholder="Recup ville">
				    </div>
				    
				    <button type="submit" class="btn btn-primary">Modifier mon profil</button>
				  </fieldset>
				</form>
	    </div>
	</c:set>