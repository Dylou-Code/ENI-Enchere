<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/layout.jsp" />

<%-- <c:if test="${not empty erreurs}">
     <script>
        window.addEventListener('DOMContentLoaded', (event) => {
            var erreurs = ${erreurs};
            var message = "Erreurs lors de l'inscription :\n" + erreurs.join("\n");
            alert(message);
        });
    </script>
</c:if> --%>

<c:set var="pageTitle" value="Accueil" scope="request" />

<c:set var="content">
    <div class="container">
      <form class="row g-3" action="<%= request.getContextPath()%>/Inscription" method="POST">
  <div class="col-md-6">
    <label for="inputEmail4" class="form-label">Pseudo</label>
    <input type="text" class="form-control" id="inputEmail4" name="pseudo" required>
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
    <label for="inputEmail" class="form-label">Email</label>
    <input type="email" class="form-control" id="inputEmail" name="email" required>
  </div>
  
   <div class="col-md-6">
    <label for="inputphoneNumber" class="form-label">Telephone</label>
    <input type="text" class="form-control" id="inputphoneNumber" name="phoneNumber" required>
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
  
   <div class="col-md-6">
    <label for="inputZip" class="form-label">Mot de passe</label>
    <input type="password" class="form-control" id="inputZip" name="password" required>
  </div>
  
  <div class="col-md-6">
    <label for="confirm" class="form-label">Confirmation</label>
    <input type="password" class="form-control" id="confirm" name="confirmPassword" required>
  </div>
  <div class="col-4">
   
  </div>
  
  <div class="col-2">
    <button type="submit" class="btn btn-primary">Créer</button>
  </div>
  
   <div class="col-2">
    <button type="button" class="btn btn-primary" onclick="cancel(event)">Annuler</button>
  </div>
</form>

    </div>
</c:set>

<script>
  function cancel(event) {
	  event.preventDefault();
	  window.location.href = "http://localhost:8080/ENI-Encheres/";
  }
</script>