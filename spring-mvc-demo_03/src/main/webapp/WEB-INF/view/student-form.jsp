<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First Name : <form:input path="firstName"/>
	<br>
	Last Name : <form:input path="lastName"/>
	<br>
	Country : <form:select path="country">
	<form:option value = "India" label = "India"/>
	<form:option value = "US" label = "US"/>
	<form:option value = "France" label = "France"/>
	<form:option value = "Brazil" label = "Brazil"/>
	</form:select>
	<br>
	Favourite language : <br>
	<form:radiobutton path = "favouriteLanguage" value = "Java"/>Java<br>
	<form:radiobutton path = "favouriteLanguage" value = "Javascript"/>Javascript<br>
	<form:radiobutton path = "favouriteLanguage" value = "python"/>Python
	<br>
	Operating Systems : <br>
	<form:checkbox path="operatingSystems" value = "Windows"/>Windows<br>
	<form:checkbox path="operatingSystems" value = "Linux"/>Linux<br>
	<form:checkbox path="operatingSystems" value = "macOS"/>macOS<br>
	<br><br>
	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>