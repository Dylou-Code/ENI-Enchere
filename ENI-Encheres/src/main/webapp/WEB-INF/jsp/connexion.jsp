<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../layout/layout.jsp" />
	
	<!-- Ajouter ce code dans les différentes pages-->

<c:set var="content">
    <div class="container-connexion">
    	<div class="form-connexion-item">
    		<%-- <form  class="form-connexion" method="post" action="<%= request.getContextPath()%>/Connexion">
	       <div class="row g-3 align-items-center pt-5">
			  <div class="col-auto">
			    <label for="identifiant" class="col-form-label">Identifiant : </label>
			  </div>
			  <div class="col-auto">
			    <input type="text" id="identifiant" class="form-control" name="identifiant">
			  </div>
			</div>
		
			<div class="row g-3 align-items-center pt-3">
			  <div class="col-auto">
			    <label for="inputPassword" class="col-form-label">Mot de passe : </label>
			  </div>
			  <div class="col-auto">
			    <input type="password" id="password" class="form-control" name="password">
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
	    </form> --%>
	    
	    
			<form class="form-connexion" method="post" action="<%= request.getContextPath()%>/Connexion">
				  
				    <div class="label-connexion">
				      <label for="identifiant">Identifiant :</label>
				    </div>
				    <div class="col-auto">
				      <input type="text" id="identifiant" class="form-control" aria-labelledby="passwordHelpInline" name="identifiant">
				    </div>
				  
				
				  
				    
				    <label for="password" class="col-form-label mt-3">Mot de passe :</label>
				    
				   <div class="col-auto">
				      <input type="password" id="password" class="form-control" aria-labelledby="passwordHelpInline" name="password">
				  </div>
				
				  <button type="submit" class="btn btn-primary mt-4" name="btnConnexion" onclick="requiredOnClick()">Connexion</button>
				
				  <div class="form-check mb-3 mt-3">
				    <input type="checkbox" class="form-check-input" id="SeSouvenirDeMoi">
				    <label class="form-check-label" for="validationFormCheck1">Se souvenir de moi</label>
				  </div>
				  <div class="forgot-connection">
				  	 <a href="<%= request.getContextPath()%>/page404">Mot de passe oublié</a>
				  </div>
				
				 
				
				  <div class="d-grid gap-2 col-6 mx-auto mt-3">
				    <button class="btn btn-primary btn-sm" type="submit" name="btnInscription" onclick="notRequiredOnClick()">Créer un compte</button>
				  </div>
			</form>
    	</div>
	   
    </div>
</c:set>

<c:if test="${not empty erreurs}">
    <div class="errors">
        <ul>
            <c:forEach items="${erreurs}" var="erreur">
                <li>${erreur}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>

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

	<!-- Ajouter ce code dans les différentes pages-->
	
	

