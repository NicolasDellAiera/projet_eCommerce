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
	<title>Header  with client menu</title>
</head>

<body>

<%@include file="header.html"%>

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
					<li><a href="${pageContext.request.contextPath}/site/afficherFormConnexion">Connexion <span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/site/seDeconnecter">Déconnexion <span class="glyphicon glyphicon-off" aria-hidden="true"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/site/afficherFormEdit">Modifier le profil <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span></a></li>
<%-- 					<li><a href="${pageContext.request.contextPath}/site/afficherFormCreation">Créer un profil</a></li> --%>
				</ul>
				<form:form cssStyle="navbar-form navbar-left" method="POST" modelAttribute="pKeyWord" action="${pageContext.request.contextPath}/site/afficherParKeyWord">
					<form:input path="designation" cssStyle="form-control"></form:input>
					<form:button type="submit" cssStyle="btn btn-default" >Rechercher <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</form:button>
				</form:form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/site/afficherPanier">Voir le panier <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></li>
					<c:if test="${pPrixPanier != 0}">	
						<li>${pPrixPanier} <span class="glyphicon glyphicon-euro" aria-hidden="true"></span></li>
					</c:if>
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
	
	<br/>
	
	<!-- SALUTATION CLIENT -->
	
	<c:if test="${pClient != null}">
		<h4 style="width:90%; margin:auto">Bonjour ${pClient.nomClient}. Ravi de vous revoir !</h4>
	</c:if>

</body>

</html>