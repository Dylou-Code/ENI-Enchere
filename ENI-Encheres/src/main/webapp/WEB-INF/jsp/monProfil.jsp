<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../layout/layout.jsp" />

<!-- Ajouter ce code dans les différentes pages-->
	<c:set var="content">
    <div class="container-infos">

		  <fieldset disabled>
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Pseudo :</label>
		      <input type="text" id="OutPutPseudo" class="form-control" value="${utilisateur.pseudo}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Nom :</label>
		      <input type="text" id="OutPutNom" class="form-control" value="${utilisateur.lastName}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Prénom :</label>
		      <input type="text" id="OutPutPrenom" class="form-control" value="${utilisateur.firstName}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Email :</label>
		      <input type="text" id="OutPutEmail" class="form-control" value="${utilisateur.email}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Téléphone :</label>
		      <input type="text" id="OutPutTelephone" class="form-control" value="${utilisateur.phoneNumber}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Rue :</label>
		      <input type="text" id="OutPutRue" class="form-control" value="${utilisateur.street}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Code Postal :</label>
		      <input type="text" id="OutPutZip" class="form-control" value="${utilisateur.zipCode}">
		    </div>
		    
		    <div class="mb-6">
		      <label for="disabledTextInput" class="form-label">Ville :</label>
		      <input type="text" id="OutPutVille" class="form-control" value="${utilisateur.city}">
		    </div>
		    <br>
		  </fieldset>
		<form class="profil-form" action="<%= request.getContextPath() %>/ModifierMonProfil" method="post">
        	<button type="submit" class="btn btn-primary">Modifier mon profil</button>
    	</form>
    </div>
</c:set>