<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorOutput.jsp" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<base href="${pageContext.request.requestURI}"/>
		<meta name="author" content="Sabine Ramp">
		<link rel="stylesheet" href="../css/overview.css">
		<title>Component Overview</title>
	</head>
	<body>
		<header>
			<h1>Component Overview</h1>
		</header>
		<main>
			<section>
				<p>Find an overview of a the currently used components on this page.</p>
				<table class="overview">
					<tr>
						<th>Identifier</th>
						<th>Name</th>
						<th>Description</th>
						<th>Type</th>
						<th>Unit</th>
						<th>Value</th>
						<th>Requested by</th>
						<th>Connected to</th>
					</tr>
					<c:forEach items="${components}" var="comp">
							<tr>
								<td>"${comp.compNr}"</td>
								<td>"${comp.compName}"</td>
								<td>"${comp.compDescription}"</td>
								<td>"${comp.compType}"</td>
								<td>"${comp.compUnit}"</td>
								<td>"${comp.compValue}"</td>
								<td>"${comp.requestor}"</td>
								<td>"${comp.busId}"</td>
							</tr>
					</c:forEach>
				</table>
			</section>
		</main>
	</body>
<%@ include file="../jspf/footer.jspf"%>