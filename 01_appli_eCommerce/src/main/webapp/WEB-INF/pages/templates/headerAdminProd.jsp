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

	<nav class="navbar navbar-inverse" style="margin-top: -20px" >
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/adminProd">Accueil <span class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<div style="margin-top: 10px" >
				<form:form cssStyle="navbar-form navbar-left" method="POST" modelAttribute="pKeyWord" action="${pageContext.request.contextPath}/adminProd/afficherParKeyWord">
					<form:input path="designation" cssStyle="form-control"></form:input>
					<form:button type="submit" cssStyle="btn btn-default" >Rechercher <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</form:button>
				</form:form>
				</div>
			</div>
		</div>
	</nav>

	<!-- MENU CATEGORIES -->

	<div class="btn-group btn-group-justified" role="group" aria-label="...">
		<c:forEach var="cat" items="${pCatListe}">
			<div class="btn-group" role="group">
				<a href="${pageContext.request.contextPath}/adminProd/afficherParCat/${cat.nomCategorie}"><button type="button" class="btn btn-default">${cat.nomCategorie}</button></a>
			</div>
		</c:forEach>
	</div>
	<br/>

</body>

</html>