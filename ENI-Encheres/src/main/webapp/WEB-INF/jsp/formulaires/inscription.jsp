<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/reset.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/layout.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/navigation.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<title>Inscription</title>
</head>
<body>



	<nav>
    <div class="nav-content">
      <div class="logo">
        <a href="#">ENI-ENCHERES</a>
      </div>
      <ul class="nav-links">
        <li><a href="<%= request.getContextPath() %>/Connexion">Connexion</a></li>
        <li><a href="<%= request.getContextPath() %>/Inscription">S'inscrire</a></li>
   
      </ul>
    </div>
  </nav>
  


	<form class="row g-3" action="<%= request.getContextPath()%>/Inscription" method="POST">
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
    <button type="submit" class="btn btn-primary">Annuler</button>
  </div>
</form>



</body>
</html>