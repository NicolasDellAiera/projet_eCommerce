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
	<title>Page produit</title>
</head>

<body>

	<%@include file="templates/header_avec_menu_client.jsp"%>

	<!-- FICHE PRODUIT -->
	
	<div style="width: 80%; margin:auto">
		<img src="${pageContext.request.contextPath}/site/photoProd?id=${pProduit.idProduit}">
		<table class="table table-hover">
			<tr>
				<th>Désignation</th>
				<td>${pProduit.designation}</td>
			</tr>
			<tr>
				<th>Description du produit</th>
				<td>${pProduit.description}</td>
			</tr>
			<tr>
				<th>Catégorie</th>
				<td>${pProduit.categorie.nomCategorie}</td>
			</tr>
			<tr>
				<th>Description de la catégorie</th>
				<td>${pProduit.categorie.description}</td>
			</tr>
			<tr>
				<th>Prix</th>
				<td>${pProduit.prix} <span class="glyphicon glyphicon-euro" aria-hidden="true"></span></td>
			</tr>
		</table>
	</div>
	
	<!-- FORMULAIRE DE COMMANDE -->
	
	<form:form action="${pageContext.request.contextPath}/site/ajouterAuPanier/${pProduit.idProduit}" method="post" modelAttribute="mLigneCommande">
		<table width="80%" align="center">
			<tr>
				<td><form:label path="quantite">Quantité :</form:label></td>
				<td><form:input path="quantite"></form:input></td>
				<td><form:errors path="quantite" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td><form:button type="submit">Ajouter au panier</form:button></td>
			</tr>
		</table>
	</form:form>
	
	<!-- MESSAGE EN CAS D'ERREUR -->
	
	<c:if test="${msgErreur != null}">
		<div class="alert alert-danger" role="alert" style="width:80%; margin:auto">
			${msgErreur}
		</div>
	</c:if>

	<%@include file="templates/footer.html"%>

</body>

</html>