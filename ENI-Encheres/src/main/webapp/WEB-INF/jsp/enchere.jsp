<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%-- <%@ include file="../layout/layout.jsp" %>  --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
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
			<c:forEach var="enchere" items="${listesEncheres}">
				<div class="col">
					<div class="card">
						<div class="card-body">
							<c:forEach var="article" items="${listeArticles}">
								<c:if test="${enchere.idArticle == article.no_article}">
									<h5 class="card-title">${article.articleName}</h5>
									<div class="card-text">
										<p class="card-text">Offreur : ${utilisateur.pseudo}</p>
										<p class="card-text">Prix : ${enchere.price}</p>
										<p class="text"> <span class="fw-bold">Fin de l'enchere :</span> ${enchere.date}</p>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</main>
</body>
</html>
