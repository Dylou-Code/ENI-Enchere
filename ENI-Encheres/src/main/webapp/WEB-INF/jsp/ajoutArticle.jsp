<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <jsp:include page="../layout/layout.jsp" />
    
  <!-- c:set permet d'ajouter la variable content du "layout.jsp" qui est le layout général du projet-->
  <c:set var="content">
  <!-- Ajout du code de la page -->
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
			
		
     
			
    </div>
</c:set>
	