<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<base href="${pageContext.request.requestURI}"/>
		<meta name="author" content="Sabine Ramp">
		<!--Border attribute has to be removed-->
		<title>Bus Overview</title>
	</head>
	<body>
		<header>
			<h1>Bus Overview</h1>
		</header>
		<main>
			<section>
				<p>Find an overview of a the currently used busses on this page.</p>
				<table border="1">
					<tr>
						<th>Identifier</th>
						<th>Name</th>
						<th>Description</th>
						<th>Requested by</th>
					</tr>
					<c:forEach items="${busses}" var="bus">
							<tr>
								<td>"${bus.busNr}"</td>
								<td>"${bus.busName}"</td>
								<td>"${bus.busDescription}"</td>
								<td>"${bus.requestor}"</td>
							</tr>
					</c:forEach>
				</table>
			</section>
		</main>
	</body>
</html>