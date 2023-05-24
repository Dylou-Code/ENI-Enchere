<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:include page="../layout/layout.jsp" />

<!-- Ajouter ce code dans les différentes pages-->
	<c:set var="content">
    	<div class="container">

	<form class="row g-3" action="/ENI-Encheres/Profil" method="post">
		<div class="col-md-6">
        	<label for="pseudoRecherche" class="form-label">Pseudo recherché :</label>
        </div>
        <div class="col-md-6">
        </div>
        <div class="col-md-6">
        	<input type="text" id="pseudoRecherche" class="form-control" required name="pseudoRecherche">
        </div>
        <div class="col-md-6">
        	<input type="submit" value="Recherche" class="btn btn-primary">
        </div>
	</form>

<% String pseudoRechercher = request.getParameter("pseudoRecherche"); %>

<%-- Condition if pour vérifier si la variable n'est pas vide --%>
<% if (pseudoRechercher != null && !pseudoRechercher.isEmpty()) { %>

    <%-- Vous devez supprimer cette ligne car vous avez déjà déclaré la variable pseudoRechercher au-dessus --%>
    <%-- String pseudo = request.getParameter("pseudoRecherche"); --%>
    <fieldset disabled>
        <br>
        <div class="mb-6">
            <label for="pseudoRecherche" class="form-label">Pseudo :</label>
            <%-- Vous devez utiliser la balise 'output' pour afficher la valeur, pas 'input' --%>
            <output type="text" id="pseudoRecherche" class="form-control" name="pseudoRecherche">
                <%= request.getAttribute("pseudo") %>
            </output>
        </div>
        <div class="mb-6">
            <label for="lastName" class="form-label">Nom :</label>
            <output type="text" id="lastName" class="form-control" name="lastName">
            	<%= request.getAttribute("lastName") %>
            </output>
        </div>
        <div class="mb-6">
            <label for="firstName" class="form-label">Prénom :</label>
            <output type="text" id="firstName" class="form-control" name="firstName">
            	<%= request.getAttribute("firstName") %>
            </output>
        </div>
        <div class="mb-6">
            <label for="email" class="form-label">Email :</label>
            <output type="text" id="email" class="form-control" name="email">
            	<%= request.getAttribute("email") %>
            </output>
        </div>
        <div class="mb-6">
            <label for="phoneNumber" class="form-label">Téléphone :</label>
            <output type="text" id="phoneNumber" class="form-control" name="phoneNumber">
            	<%= request.getAttribute("phoneNumber") %>
            </output>
        </div>
        <div class="mb-6">
            <label for="street" class="form-label">Rue :</label>
            <output type="text" id="street" class="form-control" name="street">
            	<%= request.getAttribute("street") %>
            </output>
        </div>
        <div class="mb-6">
            <label for="zipCode" class="form-label">Code Postal :</label>
            <output type="text" id="zipCode" class="form-control" name="zipCode">
            	<%= request.getAttribute("zipCode") %>
            </output>
        </div>
        <div class="mb-6">
            <label for="city" class="form-label">Ville :</label>
            <output type="text" id="city" class="form-control" name="city">
            	<%= request.getAttribute("city") %>
            </output>
        </div>
    </fieldset>
<% } %>
	    </div>
	</c:set>