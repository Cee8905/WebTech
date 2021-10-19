<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorOutput.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Component creation confirmation</title>
		<base href="${pageContext.request.requestURI}" />
	</head>
	<body>
		<h1>New component has been successfully created!</h1>
		<h3>Component properties:</h3>
		<b>Component ID: ${form.compId}</b>
		<br><b>Component name: ${form.compName}</b>
		<br><b>Component description: ${form.compDesc}</b>
		<br><b>Component type: ${form.comp_type}</b>
		<br><b>Component unit: ${form.comp_unit}</b>
		<br><b>Component value: ${form.comp_value}</b>
	</body>
<%@ include file="../jspf/footer.jspf"%>