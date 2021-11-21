<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorOutput.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Ticket dispatch confirmation</title>
		<base href="${pageContext.request.requestURI}" /> 
	</head>
	<body>
		<h1>Your ticket was submitted successfully!</h1>
		<h3>Your Ticket:</h3>
		<b>Category: ${form.category}</b>
		<br><b>Parameters: ${form.parameters}</b>
		<br><b>Feedback / other comments: ${form.fb_oc}</b>
<%@ include file="../jspf/footer.jspf"%>
</html>
