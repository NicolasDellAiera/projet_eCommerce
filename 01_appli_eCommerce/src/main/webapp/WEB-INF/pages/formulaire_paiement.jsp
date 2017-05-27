<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
	<script type="text/javascript" src="<c:url value="/ressources/js/bootstrap.js"></c:url>"></script>
	<script type="text/javascript" src="<c:url value="/ressources/js/jquery-3.2.1.js"></c:url>"></script>
	<link href="<c:url value="/ressources/styles/bootstrap.css"></c:url>" rel="stylesheet" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Formulaire de paiement</title>
</head>

<body>

	<%@include file="templates/header_avec_menu_client.jsp"%>
	
	<h4 style="width:90%; margin:auto">Récapitulatif de paiement en ligne</h4>
	<br/>

	<!-- RECAPITULATIF COMMANDE -->
	
	<div style="width: 80%; margin:auto">
		<table class="table table-hover">
			<tr>
				<th>Nom</th>
				<td>${pClient.nomClient}</td>
			</tr>
			<tr>
				<th>Adresse de facturation</th>
				<td>${pClient.adresse}</td>
			</tr>
			<tr>
				<th>Numéro de téléphone</th>
				<td>${pClient.tel}</td>
			</tr>
			<tr>
				<th>Adresse email</th>
				<td>${pClient.email}</td>
			</tr>
			<tr>
				<th>Montant TTC à payer</th>
				<td>${pPrixPanier} <span class="glyphicon glyphicon-euro" aria-hidden="true"></span></td>
			</tr>
		</table>
	</div>
	
	<!-- FORMULAIRE DE PAIEMENT -->
	
	<form:form action="${pageContext.request.contextPath}/site/validerCommande" method="post" modelAttribute="mCarteBancaire">
		<table width="80%" align="center">
			<tr>
				<td><form:label path="nomClient">Numéro de carte bancaire :</form:label></td>
				<td><form:input path="nomClient"></form:input></td>
			<tr>
				<td><form:button type="submit">Valider la commande et payer <span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span></form:button></td>
			</tr>
		</table>
	</form:form>

	<%@include file="templates/footer.html"%>

</body>

</html>