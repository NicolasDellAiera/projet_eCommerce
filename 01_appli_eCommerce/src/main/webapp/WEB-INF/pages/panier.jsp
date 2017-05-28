<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script type="text/javascript" src="<c:url value="/ressources/js/bootstrap.js"></c:url>"></script>
	<script type="text/javascript" src="<c:url value="/ressources/js/jquery-3.2.1.js"></c:url>"></script>
	<link href="<c:url value="/ressources/styles/bootstrap.css"></c:url>" rel="stylesheet" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Mon Panier</title>
</head>

<body>

	<%@include file="templates/header_avec_menu_client.jsp"%>
	
	<br/>
	
	<h4 style="width:90%; margin:auto">Mon panier : ${mPanier.montant} <span class="glyphicon glyphicon-euro" aria-hidden="true"></span></h4>
	<br/>
	
	<div style="width: 80%; margin:auto">
	<c:forEach var="lc" items="${mPanier.listeLignesCommande}">
	<ul class="media-list">
  		<li class="media">
    		<div class="media-left">
        		<img class="media-object" src="/01_appli_eCommerce/ressources/images/legume.jpg" alt="legumes">
    		</div>
    		<div class="media-body">
      			<h4 class="media-heading">${lc.quantite} ${lc.produit.designation}</h4>
      			<p>
      				Prix unitaire : ${lc.produit.prix} <span class="glyphicon glyphicon-euro" aria-hidden="true"></span>
      			</p>
      			<p>
      				Prix total : ${lc.prix} <span class="glyphicon glyphicon-euro" aria-hidden="true"></span>
      				<a class="btn btn-warning" href="${pageContext.request.contextPath}/site/retirerDuPanier/${mPanier.listeLignesCommande.indexOf(lc)}" role="button">Retirer du panier</a>
      			</p>
    		</div>
  		</li>
	</ul>
	</c:forEach>
	<br/>
	<a class="btn btn-success" href="${pageContext.request.contextPath}/site/validerPanier" role="button">Valider le panier</a>
	</div>

	<!-- MESSAGE EN CAS D'ERREUR -->
	
	<c:if test="${msgErreur != null}">
		<br/>
		<div class="alert alert-danger" role="alert" style="width:80%; margin:auto">
			${msgErreur}
		</div>
		<br/>
		<div style="width:80%; margin:auto">
			<a class="btn btn-danger" href="${pageContext.request.contextPath}/site/afficherFormConnexion" role="button">Se Connecter</a>
			<a class="btn btn-danger" href="${pageContext.request.contextPath}/site/afficherFormEdit" role="button">Créer un compte</a>
		</div>
	</c:if>
	
	<%@include file="templates/footer.html"%>

</body>

</html>