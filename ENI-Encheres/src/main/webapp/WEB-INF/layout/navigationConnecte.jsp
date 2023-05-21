<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/navigation.css">
<title>Navigation connecté</title>
</head>
<body>
	
	<nav>
    <div class="nav-content">
      <div class="logo">
        <a href="<%= request.getContextPath() %>/">ENI-ENCHERES</a>
      </div>
      <ul class="nav-links">
        <li><a href="<%= request.getContextPath() %>/Connexion">Connexion</a></li>
        <li><a href="<%= request.getContextPath() %>/Inscription">S'inscrire</a></li>
        
        <div class="dropdown">
		  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		    <img src="/layout/Profil.jpg" alt="...">
		  </a>
		  <ul class="dropdown-menu">
		    <li><a class="dropdown-item" href="#">Mon profil</a></li>
		    <li><a class="dropdown-item" href="#">Another action</a></li>
		    <li><a class="dropdown-item" href="#">Something else here</a></li>
		  </ul>
		</div>
		
		<img src="" alt="Image" class="image" onclick="toggleDropdown()">
	    <select class="dropdown" id="dropdown">
	        <option value="option1">Option 1</option>
	        <option value="option2">Option 2</option>
	        <option value="option3">Option 3</option>
	    </select>
        
      </ul>
    </div>
  </nav>
	
</body>
</html>