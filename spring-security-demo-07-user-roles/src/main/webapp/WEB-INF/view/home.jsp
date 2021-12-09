<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "security" uri = "http://www.springframework.org/security/tags" %>
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
		
		<hr>
		<!-- Display User name and role -->
		
		<p>
			User : <security:authentication property="principal.username"/>
			<br><br>
			Roles(s) : <security:authentication property="principal.authorities"/>
		</p>
		<hr>
		<security:authorize access="hasRole('MANAGER')">
			<!-- Add a link to point to /leaders ... this is for the managers -->
			
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
				(Only for Managers)
			</p>
			
		 </security:authorize>
		 <security:authorize access="hasRole('ADMIN')">	
			<!-- Add a link to point /systems ... this is for the admins -->
			<hr>
			
			<p>
				<a href="${pageContext.request.contextPath}/systems">IT Systems meeting</a>
				(Only for System admins)
			</p>
		 </security:authorize>
		
		<hr>
		
		<!-- Add a logout button --> 
		<form:form action = "${pageContext.request.contextPath}/logout" 
		method = "POST">
			
			<input type = "submit" value = "Logout" />
		</form:form>
	</body>
</html>