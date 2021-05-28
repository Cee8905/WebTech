<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Ticket dispatch confirmation</title>
	</head>
	<body>
		<h1>Your ticket was submitted successfully!</h1>
		<h3>Your Ticket:</h3>
		<b>Category: ${form.category}</b>
		<br><b>Parameters: ${form.parameters}</b>
		<br><b>Feedback / other comments: ${form.fb_oc}</b>
	</body>
</html>