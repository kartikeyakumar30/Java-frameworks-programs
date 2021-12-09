<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title> KK Security Home Page</title>
		
	</head>
	<body>
		<h2>KK Security Home Page </h2>
		<hr>
		<p>
		Welcome to KK Security Home Page!
		</p>
		<!-- Add a logout button --> 
		<form:form action = "${pageContext.request.contextPath}/logout" 
		method = "POST">
			
			<input type = "submit" value = "Logout" />
		</form:form>
	</body>
</html>