<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath()%>/css/navigation.css">
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath()%>/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath()%>/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<title>Page 404</title>
</head>
<body>
	
	<main>
	
		<div class="container">
			<div class="wrapper-404">
				<img src="<%= request.getContextPath()%>/img/image404.jpg"
								class="image404" alt="image voiture">
			</div>
			
		</div>
	</main>
</body>
</html>