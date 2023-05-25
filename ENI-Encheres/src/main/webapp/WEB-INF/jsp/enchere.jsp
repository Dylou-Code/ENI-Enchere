<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/navigation.jsp" />


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Encheres</title>
   
 
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/reset.css">
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

		<main class="main">
		<div class="container">
			<div class="row row-cols-1 row-cols-md-4 g-4">
			<c:forEach var="article" items="${listesArticles }">
		  		<div class="col">
		    
					<div class="card">
					    <div class="card-body">
					      <h5 class="card-title" > article</h5>
					      <p class="card-text"> Prix :</p>
						    <div class="card-text">
						      <p class="text"> <span class="fw-bold">Fin de l'enchere :</p>		
     				    </div>
						    
						     <a href="<%= request.getContextPath() %>/detailArticle" class="btn btn-primary">Voir plus</a>
						   
						    
				    	</div>
				  	</div>
				  </div>
				</c:forEach>
				
		  </div>
		</div>
		
		 </main>  	
</body>
</html>
		  