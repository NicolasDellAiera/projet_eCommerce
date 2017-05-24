<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<script type="text/javascript" src="<c:url value="/ressources/js/bootstrap.js"></c:url>"></script>
	<script type="text/javascript" src="<c:url value="/ressources/js/jquery-3.2.1.js"></c:url>"></script>
	<link href="<c:url value="/ressources/styles/bootstrap.css"></c:url>" rel="stylesheet" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Page d'accueil</title>
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
				<a class="navbar-brand" href="${pageContext.request.contextPath}/site">Accueil</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Profil<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/seConnecter">Connection</a></li>
							<li><a href="${pageContext.request.contextPath}/seDeconnecter">Déconnection</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="${pageContext.request.contextPath}/editerClient">Modifier le profil</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="${pageContext.request.contextPath}/creerClient">Créer un profil</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Rechercher <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="afficherPanier">Voir le panier</a></li>
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
	
	<table class="table table-hover">
		<tr style="background-color:black; color:white">
			<th>Désignation</th>
		</tr>
		<c:forEach var="prod" items="${pPrListe}">
			<tr>
				<td>${prod.designation}</td>
			</tr>
		</c:forEach>
			
		</table>

	<%@include file="templates/footer.html"%>

</body>

</html>