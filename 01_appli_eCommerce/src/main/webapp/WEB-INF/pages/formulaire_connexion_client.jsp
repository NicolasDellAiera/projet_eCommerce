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
	<title>Page de connexion</title>
</head>

<body>

	<%@include file="templates/header_avec_menu_client.jsp"%>
	
	<form:form action="${pageContext.request.contextPath}/site/soumettreFormConnexion" method="post" modelAttribute="mClient">
		<table width="80%" align="center">
			<tr>
				<td><form:label path="email">Adresse email :</form:label></td>
				<td><form:input path="email"></form:input></td>
			<tr>
			<tr>
				<td><p></p></td>
				<td><p></p></td>
			</tr>
			<tr>
				<td><form:label path="mdp">Mot de passe :</form:label></td>
				<td><form:password path="mdp"></form:password></td>
			</tr>
			<tr>
				<td><p></p></td>
				<td><p></p></td>
			</tr>
			<tr>
				<td><form:button type="submit" cssStyle="btn btn-default">Se Connecter</form:button></td>
			</tr>
		</table>
	</form:form>
	<br/>
	
	<!-- MESSAGE EN CAS D'ERREUR -->
	
	<c:if test="${msgErreur != null}">
		<div class="alert alert-danger" role="alert" style="width:80%; margin:auto">
			${msgErreur}
		</div>
	</c:if>
	
	<%@include file="templates/footer.html"%>

</body>

</html>