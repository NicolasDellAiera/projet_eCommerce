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
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/site">Accueil <span class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/site/seConnecter">Connexion <span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/site/seDeconnecter">D�connexion <span class="glyphicon glyphicon-off" aria-hidden="true"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/site/editerClient">Modifier le profil</a></li>
					<li><a href="${pageContext.request.contextPath}/site/creerClient">Cr�er un profil</a></li>
				</ul>
				<form:form cssStyle="navbar-form navbar-left" method="POST" modelAttribute="pKeyWord" action="${pageContext.request.contextPath}/site/afficherParKeyWord">
					<form:input path="designation" cssStyle="form-control"></form:input>
					<form:button type="submit" cssStyle="btn btn-default" >Rechercher <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</form:button>
				</form:form>
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
	
	<!-- TABLE PRODUITS -->
	
	<div style="width: 80%; margin:auto">
	<c:forEach var="prod" items="${pPrListe}">
	<ul class="media-list">
  		<li class="media">
    		<div class="media-left">
      			<a href="${pageContext.request.contextPath}/site/afficherFicheProd/${prod.idProduit}">
        			<img class="media-object" src="/01_appli_eCommerce/ressources/images/legume.jpg" alt="legumes">
     			</a>
    		</div>
    		<div class="media-body">
      			<h4 class="media-heading">${prod.designation}</h4>
      			<p>Prix unitaire : ${prod.prix} <span class="glyphicon glyphicon-euro" aria-hidden="true"></span></p>
    		</div>
  		</li>
	</ul>
	</c:forEach>
	</div>

	<%@include file="templates/footer.html"%>

</body>

</html>