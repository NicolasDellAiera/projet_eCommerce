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
	<title>Ajouter un admin prod</title>
</head>

<body>

	<%@include file="templates/headerAdminCat.jsp"%>
	<br/>
	<form:form action="${pageContext.request.contextPath}/adminCat/ajoutAdmin" method="post" modelAttribute="mAdmin">
		<table width="80%" align="center">
			<tr>
				<td><form:label path="username">Username :</form:label></td>
				<td><form:input path="username"></form:input></td>
			</tr>
			<tr>
				<td><p></p></td>
				<td><p></p></td>
			</tr>
			<tr>
				<td><form:label path="password">Password :</form:label></td>
				<td><form:input path="password"></form:input></td>
			</tr>
			<tr>
				<td><p></p></td>
				<td><p></p></td>
			</tr>
			<tr>
				<td><form:label path="activated">Activated :</form:label></td>
				<td><form:input path="activated"></form:input></td>
			</tr>
			<tr>
				<td><p></p></td>
				<td><p></p></td>
			</tr>
			<tr>
				<td><form:button type="submit" cssStyle="btn btn-default">Editer</form:button></td>
			</tr>
		</table>
	</form:form>
	<br>
	
	<%@include file="templates/footerAdmin.jsp"%>

</body>

</html>