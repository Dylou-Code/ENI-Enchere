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
<title>ENI-ENCHERES</title>
 
</head>

<body>
<nav>
    <div class="nav-content">
      <div class="logo">
        <a href="#">ENI-ENCHERES</a>
      </div>
      <ul class="nav-links">
        <li><a href="#">Connexion</a></li>
        <li><a href="<%= request.getContextPath() %>/Inscription">S'inscrire</a></li>
   
      </ul>
    </div>
  </nav>
	
	<h3>Listes enchères</h3>
	
	<label for="site-search">Filtres:</label>
<input type="search" id="site-search" name="q">

<button class="btn btn-primary">Search</button>
	<br>
	<label for="categories">Catégories</label>
	<br>

<select name="categorie" id="categorie-select">
    <option value="">Toutes</option>
    
</select>

<br>

<div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">PC Gamer</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
	
	
	
	 
</body>
</html>



