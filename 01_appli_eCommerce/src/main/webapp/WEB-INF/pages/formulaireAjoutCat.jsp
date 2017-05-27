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
	<title>Ajouter une categorie</title>
</head>

<body>

	<%@include file="templates/headerAdminCat.jsp"%>
	
	<form:form action="${pageContext.request.contextPath}/adminCat/ajoutCat" method="post" modelAttribute="mCategorie">
		<table width="80%" align="center">
			<tr>
				<td><form:label path="nomCategorie">Nom de la categorie :</form:label></td>
				<td><form:input path="nomCategorie"></form:input></td>
			<tr>
			<tr>
				<td><form:label path="description">Description :</form:label></td>
				<td><form:textarea path="description" rows="5" ></form:textarea></td>
			<tr>
			<br/>
			<tr>
				<td><form:button type="submit" cssStyle="btn btn-default">Editer</form:button></td>
			</tr>
		</table>
	</form:form>
	
	<%@include file="templates/footerAdmin.jsp"%>

</body>

</html>