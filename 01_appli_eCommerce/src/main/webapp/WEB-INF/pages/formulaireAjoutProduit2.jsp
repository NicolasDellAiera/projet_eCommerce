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
	<title>Ajouter un produit</title>
</head>

<body>

	<%@include file="templates/headerAdminProd.jsp"%>
	
	<form:form action="${pageContext.request.contextPath}/adminProd/ajoutProduit" method="post" modelAttribute="mProduit">
		<table width="80%" align="center">
			<tr>
				<td><form:label path="designation">Nom du produit :</form:label></td>
				<td><form:input path="designation"></form:input></td>
			<tr>
			<tr>
				<td><form:label path="description">Description :</form:label></td>
				<td><form:textarea path="description" rows="5" ></form:textarea></td>
			<tr>
			<tr>
				<td><form:label path="prix">Prix :</form:label></td>
				<td><form:input type="number" step="0.01" path="prix"></form:input></td>
			<tr>
			<tr>
				<td><form:label path="quantite">Quantité :</form:label></td>
				<td><form:input type="number" path="quantite"></form:input></td>
			<tr>
			<tr>
				<td><form:label path="selection">Disponibilité :</form:label></td>
				<td><form:input type="number" path="selection"></form:input></td>
			<tr>
			<tr>
				<td><form:label path="categorie.idCategorie" for="categorie" >Catégorie :</form:label></td>
				<td><form:select id="categorie" path="categorie.idCategorie" >
					<c:forEach var="cat" items="${pCatListe}">
						<option value="${cat.idCategorie}">${cat.nomCategorie}</option>
					</c:forEach>
				</form:select>
				</td>
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