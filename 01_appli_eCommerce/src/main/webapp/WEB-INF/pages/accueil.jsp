<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<!-- 	<script type="text/javascript" src="js/bootstrap.js"></script> -->

	<link  href="<c:url value="/ressources/css/bootstrap.css"></c:url>" />
		<link  href="<c:url value="/ressources/css/bootstrap-theme.css"></c:url>" />
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
				<a class="navbar-brand" href="site">Accueil</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Profil<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="seConnecter">Connection</a></li>
							<li><a href="seDeconnecter">Déconnection</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="editer">Modifier le profil</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="creer">Créer un profil</a></li>
						</ul>
					</li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Rechercher<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="afficherPanier">Voir le panier</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	
	<div class="alert alert-success" role="alert">TEST ESSAI</div>

	<%@include file="templates/footer.html"%>

</body>

</html>