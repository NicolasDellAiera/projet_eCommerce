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

	<%@include file="templates/headerAdminCat.jsp"%>
	
	<!-- FICHE PRODUIT -->
	
	<div style="width: 80%; margin:auto">
		<img class="media-object" src="/01_appli_eCommerce/ressources/images/legume.jpg" alt="legumes">
		<table class="table table-hover">
			<tr>
				<th>Designation</th>
				<td>${pProduit.designation}</td>
			</tr>
			<tr>
				<th>Description du produit</th>
				<td>${pProduit.description}</td>
			</tr>
			<tr>
				<th>Categorie</th>
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

	<%@include file="templates/footerAdmin.jsp"%>

</body>

</html>