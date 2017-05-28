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
	<title>Modifier un admin prod</title>
</head>

<body>

	<%@include file="templates/headerAdminCat.jsp"%>
	
	<form:form action="${pageContext.request.contextPath}/adminCat/modifierAdmin" method="post" modelAttribute="mAdmin2">
		<table width="80%" align="center">
			<tr>
				<td><form:label path="idAdmin" type="hidden" ></form:label></td>
				<td><form:input path="idAdmin" type="hidden" value="${pAdmin.idAdmin}" ></form:input></td>
			<tr>
			<tr>
				<td><form:label path="username">Username :</form:label></td>
				<td><form:input path="username" value="${pAdmin.username}" ></form:input></td>
			<tr>
			<tr>
				<td><form:label path="password">Password :</form:label></td>
				<td><form:input path="password" value="${pAdmin.password}" ></form:input></td>
			<tr>
			<tr>
				<td><form:label path="activated">Activated :</form:label></td>
				<td><form:input path="activated" value="${pAdmin.activated}" ></form:input></td>
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