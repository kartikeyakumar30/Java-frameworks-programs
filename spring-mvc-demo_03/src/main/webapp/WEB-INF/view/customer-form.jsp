<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer registration form</title>
<style type="text/css">
.error{
color : red;
}
</style>
</head>
<body>
Fill out the form. Asterisk(*) means required:<br><br>
<form:form action = "processForm" modelAttribute = "customer">
First Name <form:input path = "firstName"/>	<br>
Last name <form:input path = "lastName"/>	<br>
<form:errors path = "lastName" cssClass = "error"/>
Free Passes <form:input path = "freePasses"/>	<br>
<form:errors path = "freePasses" cssClass = "error"/>
Postal Code <form:input path = "postalCode"/>	<br>
<form:errors path = "postalCode" cssClass = "error"/>
Course Code <form:input path = "courseCode"/>	<br>
<form:errors path = "courseCode" cssClass = "error"/>
<br><br>
<input type = "submit" value = "submit"/>
</form:form>
</body>
</html>