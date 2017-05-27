<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	
	<body style="background-color: #F5ECCE" >
		<div style="background-color: #008000; margin-top: 5%; margin-left: 25%; height: 100%; width: 50%; color: white" >
			<form action="j_spring_security_check" method="post" >
				<table width="80%" align="center">
					<tr>
						<td>Login :</td>
						<td><input type="text" name="j_username" ></td>
					</tr>
					<tr>
						<td>MDP :</td>
						<td><input type="text" name="j_password" ></td>
					</tr>
					<tr>
						<td><input type="submit" value="connexion" ></td>
						<td></td>
					</tr>
				</table>
			</form>
			<c:if test="${not empty erreur}">
				<div style="text-align: center" >
					<h1 style="color: red" >Vous vous êtes trompé</h1>
				</div>
			</c:if>
		</div>
	</body>