<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author" content="Caroline Brun">
		<title>Error Page</title>

</head>
<body>
		<h1>Oops</h1>
		Looks like there is a mistake in our code. 
		<br>Please contact us at: <b>admin@demo.org</b>.
		<br>The Error is: ${pageContext.exception}
		<p><b>Stack trace:</b>
			<c:forEach var = "trace" items = "${pageContext.exception.stackTrace}">
				<br>${trace}
			</c:forEach>
			<a href="./index.html" >Return to Homepage</a>
		</p>
	</body>
</html>