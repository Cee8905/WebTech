<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.requestURI}" />
<title>Registration data</title>
</head>
<body>
	<h2>Registration first no mvs</h2>

	<h3>Your input through the mvc pattern</h3>
	<br>
	<b>E-Mail Address:</b> ${myuser.email}
	<br>
	<b>Username:</b> ${myuser.username}
	<br>
	<b>Password:</b> ${myuser.password}
	<br>
	<b>Departement:</b> ${myuser.departement}
	<br>
	<b>Admin?</b> ${myuser.isadmin}
	
	<footer> Qiankai Lei | Sabine Ramp | Caroline Brun </footer>
</body>
</html>
<%--<%@ include file="footer.jspf"%>--%>