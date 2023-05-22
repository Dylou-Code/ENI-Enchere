<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:include page="../layout/layout.jsp" />

<!-- Ajouter ce code dans les différentes pages-->
	<c:set var="content">
    	<div class="container">

		    	<form>
			        <div class="mb-6">
				      <label for="disabledTextInput" class="form-label">Pseudo recherché :</label>
				      <input type="text" id="pseudoRecherche" class="form-control" required name="pseudoRecherche">
				      <br>
				      <input type="submit" value="Recherche" class="btn btn-primary">
				    </div>
				</form>
				
				<form>
					<% String pseudoRechercher = request.getParameter("pseudoRecherche"); %>
	
	    			<%-- Condition if pour vérifier si la variable n'est pas vide --%>
	    			<% if (pseudoRechercher != null && !pseudoRechercher.isEmpty()) { %>
	    			
				    <% String pseudo = request.getParameter("pseudoRecherche"); %>
					    <fieldset disabled>
					    <div class="mb-6">
					      <label for="disabledTextInput" class="form-label">Pseudo :</label>
					      <input type="text" id="pseudo" class="form-control" name="pseudo">
					    </div>
					    <div class="mb-6">
					      <label for="disabledTextInput" class="form-label">Nom :</label>
					      <input type="text" id="OutPutNom" class="form-control" name="lastName">
					    </div>
					    <div class="mb-6">
					      <label for="disabledTextInput" class="form-label">Prénom :</label>
					      <input type="text" id="OutPutPrenom" class="form-control" name="firstName">
					    </div>
					    <div class="mb-6">
					      <label for="disabledTextInput" class="form-label">Email :</label>
					      <input type="text" id="OutPutEmail" class="form-control" name="email">
					    </div>
					    <div class="mb-6">
					      <label for="disabledTextInput" class="form-label">Téléphone :</label>
					      <input type="text" id="OutPutTelephone" class="form-control" name="phoneNumber">
					    </div>
					    <div class="mb-6">
					      <label for="disabledTextInput" class="form-label">Rue :</label>
					      <input type="text" id="OutPutRue" class="form-control" name="street">
					    </div>
					    <div class="mb-6">
					      <label for="disabledTextInput" class="form-label">Code Postal :</label>
					      <input type="text" id="OutPutZip" class="form-control" name="zipCode">
					    </div>
					    <div class="mb-6">
					      <label for="disabledTextInput" class="form-label">Ville :</label>
					      <input type="text" id="OutPutVille" class="form-control" name="city">
					    </div>
					  </fieldset>
				 <% } %>
				 <!-- out.println("<p>Aucun utilisateur trouvé avec le pseudo : " + pseudoRecherche + "</p>"); -->
			</form>
	    </div>
	</c:set>