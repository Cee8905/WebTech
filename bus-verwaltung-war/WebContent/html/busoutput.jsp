<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Bus creation confirmation</title>
	</head>
	<body>
		<h1>New bus has been successfully created!</h1>
		<h3>Bus properties:</h3>
		<b>Bus ID: ${form.busId}</b>
		<br><b>Bus number: ${form.busNr}</b>
		<br><b>Bus name:  ${form.bus_name}</b>
		<br><b>Bus description: ${form.bus_description}</b>
	</body>
</html>