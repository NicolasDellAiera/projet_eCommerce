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
	<title>Liste Admin Prod</title>
</head>

<body>

	<%@include file="templates/headerAdminCat.jsp"%>
	
	<!-- TABLE ADMINS PROD -->
	
	<br/>
	<br/>
	<div style="width: 80%; margin:auto">
	<table class="table table-hover">
		<tr>
			<td><b>username</b></td>
			<td><b>password</b></td>
			<td><b>activated</b></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach var="admin" items="${pListeAdmin}">
			<tr>
				<td>${admin.username}</td>
				<td>${admin.password}</td>
				<td>${admin.activated}</td>
				<td>
				<a href="${pageContext.request.contextPath}/adminCat/formulaireModifierAdmin?idAdmin=${admin.idAdmin}">modifier</a>
				</td>
				<td>
				<a href="${pageContext.request.contextPath}/adminCat/supprimerAdmin?idAdmin=${admin.idAdmin}">supprimer</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<a href="${pageContext.request.contextPath}/adminCat/formulaireAjoutAdmin">
				<button type="button" class="btn btn-default" >Ajouter un admin</button>
				</a>
			</td>
			<td></td>
			<td></td>
		</tr>
	</table>
	</div>
	<br/>

	<%@include file="templates/footerAdmin.jsp"%>

</body>

</html>