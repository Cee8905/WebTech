<!-- Author: Caroline Brun -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorOutput.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.requestURI}" />
<title>Sign up</title>
</head>
<body>
	
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

</body>
<%@ include file="../jspf/footer.jspf"%>