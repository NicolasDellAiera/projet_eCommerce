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
	<title>Page de connexion</title>
</head>

<body>

	<%@include file="templates/header_avec_menu_client.jsp"%>
	
	<form:form action="${pageContext.request.contextPath}/site/soumettreFormEdition" method="post" modelAttribute="mCLientEdit">
		<table width="80%" align="center">
			<tr>
				<td><form:label path="idClient">Numéro de client :</form:label></td>
				<td><form:input path="idClient" readonly="true"></form:input></td>
			<tr>
			<tr>
				<td><form:label path="nomClient">Nouveau nom :</form:label></td>
				<td><form:input path="nomClient"></form:input></td>
				<td><form:errors path="nomClient" cssStyle="color:red"></form:errors></td>
			<tr>
			<tr>
				<td><form:label path="adresse">Nouvelle adresse de livraison :</form:label></td>
				<td><form:input path="adresse"></form:input></td>
				<td><form:errors path="adresse" cssStyle="color:red"></form:errors></td>
			<tr>
			<tr>
				<td><form:label path="tel">Nouveau numéro de téléphone :</form:label></td>
				<td><form:input path="tel"></form:input></td>
			<tr>
			<tr>
				<td><form:label path="email">Nouvelle adresse email :</form:label></td>
				<td><form:input path="email"></form:input></td>
				<td><form:errors path="email" cssStyle="color:red"></form:errors></td>
			<tr>
			<tr>
				<td><form:label path="mdp">Nouveau mot de passe :</form:label></td>
				<td><form:password path="mdp"></form:password></td>
				<td><form:errors path="mdp" cssStyle="color:red"></form:errors></td>
			<tr>
				<td><form:button type="submit" cssStyle="btn btn-default">Editer</form:button></td>
			</tr>
		</table>
	</form:form>
	
	<c:if test="${msgErreur != null}">
		<div class="alert alert-danger" role="alert" style="width:80%; margin:auto">
			${msgErreur}
		</div>
	</c:if>
	
	<%@include file="templates/footer.html"%>

</body>

</html>