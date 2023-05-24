<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <jsp:include page="../layout/layout.jsp" />
    
  <!-- c:set permet d'ajouter la variable content du "layout.jsp" qui est le layout général du projet-->
  <c:set var="content">
  <!-- Ajout du code de la page -->
<<<<<<< HEAD
  
  <main>
  	<div class="container">
  	
  		<div class="Title">
=======
    <div class="container">
    	<div class="Title">
    		 <h2>Nouvelle Vente</h2>
    	</div>
    	
    	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">Email address</label>
 			 <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
		<!-- gerer récupération des catégorie(boucle forEach) -->
		<label for="Categories" class="form-label">Catégories</label>
		<select class="form-select" aria-label="categories"  name="categories"  >
		  <option selected value="">Sélectionnez</option>
		 
		<%--   <c:forEach items="" >
		  	 <option value="${ nom.no_categorie }"><c:out value="${ nom.libelle }"/></option>
		  </c:forEach> --%>
		  
		  	<%-- <c:forEach items="${categories}" var="category">
			    <option value="${category.no_categorie}">
			      <c:out value="${category.libelle}" />
			    </option>
  			</c:forEach> --%>
  			
  			<c:forEach var="category" items="${categories}">
                <option value="${category.id}">
                    <c:out value="${category.name}" />
                </option>
            </c:forEach>
		
		<label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
		<select class="form-select" aria-label="Default select example">
		  <option selected>Catégories : </option>
		  <option value="1">One</option>
		  <option value="2">Two</option>
		  <option value="3">Three</option>
		</select>
		
		<br>
	  <div class="mb-3">
	    <input type="file" class="form-control" aria-label="file example" required>
	    <div class="invalid-feedback">Example invalid form file feedback</div>
	  </div>
			
		
	<fieldset>
	    <legend>Retrait</legend>
	<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label"  >Rue</label>
 			 <input type="text" class="form-control" id="street" name="street" >
		</div>
	
	   <div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">Code Postal</label>
 			 <input type="text" class="form-control" id="zipCode" name="zipCode">
		</div>
		
		<div class="mb-3">
  			<label for="exampleFormControlInput1" class="form-label">Ville</label>
 			 <input type="text" class="form-control" id="city" name="city">
		</div>
	</fieldset>
	
	<div class="d-grid gap-5 d-md-block">
	  <button class="btn btn-primary" type="submit">Enregistrer</button>
	  <button class="btn btn-danger" type="submit">Annuler</button>
	</div>	
    	</form>
  	
  	</div>
  	
  </main>
    
    	
    	
</body>
</html>
	