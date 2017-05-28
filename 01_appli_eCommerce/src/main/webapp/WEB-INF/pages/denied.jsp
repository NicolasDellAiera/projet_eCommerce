<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Denied</title>
	</head>
	
	<body>
		<div style="background-color: #222222; margin-top: 5%; margin-left: 25%; height: 100%; width: 50%; color: white" >
			<br/>
			<h3 style="color: red; text-align: center" >Vous n'êtes pas autorisé à acceder à cette page</h3>
			<br/>
			<a href="${pageContext.request.contextPath}/site">
			<button type="button" class="btn btn-danger" style="margin-left: 45%" >Recommencer</button>
			</a>
			<br/>
			<p></p>
		</div>
	</body>

</html>