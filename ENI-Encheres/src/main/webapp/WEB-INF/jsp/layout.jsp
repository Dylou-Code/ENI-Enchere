<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<<<<<< Updated upstream:ENI-Encheres/src/main/webapp/WEB-INF/jsp/layout.jsp
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
=======
    
	<jsp:include page="../layout/layout.jsp" />
	
	<!-- Ajouter ce code dans les différentes pages-->
	
		<c:set var="content">
	    <div class="container">
		   <form method="post" action="Connexion">
		       <div class="row g-3 align-items-center">
				  <div class="col-auto">
				    <label for="inputPassword6" class="col-form-label">Identifiant : </label>
				  </div>
				  <div class="col-auto">
				    <input type="text" id="identifiant" class="form-control" aria-labelledby="passwordHelpInline">
				  </div>
				</div>
			
				<div class="row g-3 align-items-center">
				  <div class="col-auto">
				    <label for="inputPassword6" class="col-form-label">Mot de passe : </label>
				  </div>
				  <div class="col-auto">
				    <input type="password" id="password" class="form-control" aria-labelledby="passwordHelpInline">
				  </div>
				</div>
			
		        <button type="button" class="btn btn-primary btn-sm">Connexion</button>
		        
		          <div class="form-check mb-3">
				    <input type="checkbox" class="form-check-input" id="SeSouvenirDeMoi" required>
				    <label class="form-check-label" for="validationFormCheck1">Se souvenir de moi</label>
				  </div>
		 
		       		<a href="adresse de redirection" > Mot de passe oublié </a> 
		        
		        <div class="d-grid gap-2 col-4 mx-auto">
			  		<button class="btn btn-primary" type="button">Créer un compte</button>
				</div>    
		    </form>
	    </div>
	</c:set>
>>>>>>> Stashed changes:ENI-Encheres/src/main/webapp/WEB-INF/jsp/connexion.jsp
