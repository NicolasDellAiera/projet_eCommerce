<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Denied</title>
	</head>
	
	<body style="background-color: #F5ECCE" >
		<div style="background-color: #008000; margin-top: 5%; margin-left: 25%; height: 100%; width: 50%; color: white" >
			<h3 style="color: red; text-align: center" >Vous n'êtes pas autorisé à acceder à cette page</h3>
			<a href="${pageContext.request.contextPath}/site" >Recommencer</a>
		</div>
	</body>

</html>