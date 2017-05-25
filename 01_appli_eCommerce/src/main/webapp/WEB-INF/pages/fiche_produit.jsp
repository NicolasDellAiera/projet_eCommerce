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
	<title>Fiche Produit</title>
</head>

<body>

	<%@include file="templates/header.html"%>
	
	<!-- MENU -->

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/site">Accueil <span class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/seConnecter">Connection <span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/seDeconnecter">Déconnection <span class="glyphicon glyphicon-off" aria-hidden="true"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/editerClient">Modifier le profil</a></li>
					<li><a href="${pageContext.request.contextPath}/creerClient">Créer un profil</a></li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Rechercher <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="afficherPanier">Voir le panier <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- MENU CATEGORIES -->

	<div class="btn-group btn-group-justified" role="group" aria-label="...">
		<c:forEach var="cat" items="${pCatListe}">
			<div class="btn-group" role="group">
				<a href="${pageContext.request.contextPath}/site/afficherParCat/${cat.nomCategorie}"><button type="button" class="btn btn-default">${cat.nomCategorie}</button></a>
			</div>
		</c:forEach>
	</div>

	<!-- FICHE PRODUIT -->
	
	<div style="width: 80%; margin:auto">
		<img class="media-object" src="/01_appli_eCommerce/ressources/images/legume.jpg" alt="legumes">
		<table class="table table-hover">
			<tr>
				<th>Designation</th>
				<td>${pProduit.designation}</td>
			</tr>
			<tr>
				<th>Description</th>
				<td>${pProduit.description}</td>
			</tr>
			<tr>
				<th>Categorie</th>
				<td>${pProduit.categorie.nomCategorie}</td>
			</tr>
			<tr>
				<th>Prix</th>
				<td>${pProduit.prix}</td>
			</tr>
		</table>
	</div>
	
	<form:form action="ajouterAuPanier" method="post" modelAttribute="mLigneCommande">
		<table width="80%" align="center">
			<tr>
				<td><form:label path="quantite">Quantité :</form:label></td>
				<td><form:input path="quantite"></form:input></td>

			<tr>
				<td><form:button type="submit" cssClass="btn btn-default">Ajouter au panier</form:button></td>
			</tr>
		</table>
	</form:form>

	<%@include file="templates/footer.html"%>

</body>

</html>