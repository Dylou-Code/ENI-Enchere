<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/navigation.css">
<title>Insert title here</title>
</head>
<body>
	
	<nav>
    <div class="nav-content">
      <div class="logo">
        <a href="/">ENI-ENCHERES</a>
      </div>
      <ul class="nav-links">
        <li><a href="<%= request.getContextPath() %>/Connexion">Connexion</a></li>
        <li><a href="<%= request.getContextPath() %>/Inscription">S'inscrire</a></li>
   
      </ul>
    </div>
  </nav>
	
</body>
</html>