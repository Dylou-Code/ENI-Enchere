<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="../layout/layout.jsp" />
	
	<!-- Ajouter ce code dans les différentes pages-->

<c:set var="content">
    <div class="container">
	   <form method="post" action="<%= request.getContextPath()%>/Connexion">
	       <div class="row g-3 align-items-center">
			  <div class="col-auto">
			    <label for="inputPassword6" class="col-form-label">Identifiant : </label>
			  </div>
			  <div class="col-auto">
			    <input type="text" id="identifiant" class="form-control" aria-labelledby="passwordHelpInline" name="identifiant">
			  </div>
			</div>
		
			<div class="row g-3 align-items-center">
			  <div class="col-auto">
			    <label for="inputPassword6" class="col-form-label">Mot de passe : </label>
			  </div>
			  <div class="col-auto">
			    <input type="password" id="password" class="form-control" aria-labelledby="passwordHelpInline" name="password">
			  </div>
			</div>
		
	        <button type="submit" class="btn btn-primary btn-sm" name="btnConnexion" onclick="requiredOnClick()">Connexion</button>
	        
	          <div class="form-check mb-3">
			    <input type="checkbox" class="form-check-input" id="SeSouvenirDeMoi">
			    <label class="form-check-label" for="validationFormCheck1">Se souvenir de moi</label>
			  </div>
	 
	       		<a href="adresse de redirection" > Mot de passe oublié </a> 
	        
	        <div class="d-grid gap-2 col-4 mx-auto">
		  		<button class="btn btn-primary" type="submit" name="btnInscription" onclick="notRequiredOnClick()">Créer un compte</button>
			</div>
	    </form>
    </div>
</c:set>

<script>
  function requiredOnClick() {
    var identifiant = document.getElementById('identifiant');
    var password = document.getElementById('password');

    if (identifiant.value.trim() === '' || password.value.trim() === '') {
      identifiant.required = true;
      password.required = true;
    } else {
      identifiant.required = false;
      password.required = false;
    }
  }
  
  function notRequiredOnClick() {
	    var identifiant = document.getElementById('identifiant');
	    var password = document.getElementById('password');

	    identifiant.required = false;
	    password.required = false;
	    }
</script>
