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

	<%@include file="templates/headerAdminCat.jsp"%>
	
	<!-- TABLE PRODUITS -->
	
	<div style="width: 80%; margin:auto">
	<c:forEach var="prod" items="${pPrListe}">
	<ul class="media-list">
  		<li class="media">
    		<div class="media-left">
      			<a href="${pageContext.request.contextPath}/adminCat/afficherFicheProd/${prod.idProduit}">
        			<img src="${pageContext.request.contextPath}/adminCat/photoProd?id=${prod.idProduit}">
     			</a>
    		</div>
    		<div class="media-body">
      			<h4 class="media-heading">${prod.designation}</h4>
      			<p>Prix unitaire : ${prod.prix} <span class="glyphicon glyphicon-euro" aria-hidden="true"></span></p>
      			<a href="${pageContext.request.contextPath}/adminCat/formulaireModifierProduit?idProduit=${prod.idProduit}">modifier</a>
      			<a href="${pageContext.request.contextPath}/adminCat/supprimerProduit?idProduit=${prod.idProduit}">supprimer</a>
    		</div>
  		</li>
	</ul>
	</c:forEach>
	<br/>
	<a href="${pageContext.request.contextPath}/adminCat/formulaireAjoutProduit">
	<button type="button" class="btn btn-default" >Ajouter un produit</button>
	</a>
	</div>

	<%@include file="templates/footerAdmin.jsp"%>

</body>

</html>