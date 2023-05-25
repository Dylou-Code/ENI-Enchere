<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/reset.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<footer class="mt-5">
    <div class="bottom-details">
      <div class="bottom_text">
        <span class="copyright_text">Copyright © 2023 <a href="#">ENI.</a>All rights reserved</span>
        <span class="policy_terms">
         <a href="<%= request.getContextPath()%>/page404">Politique de confidentialité</a>
          <a href="<%= request.getContextPath()%>/page404">Termes et conditions</a>
        </span>
      </div>
    </div>
  </footer> 
	
</body>
</html>