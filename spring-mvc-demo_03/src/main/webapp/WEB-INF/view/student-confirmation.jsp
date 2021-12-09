<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student confirmation</title>
</head>
<body>

Student registration confirmed for : 						<br>
First Name : ${student.firstName} 							<br>
Last name : ${student.lastName} 							<br>
Country : ${student.country} 								<br>
Favourite language : ${student.favouriteLanguage}			<br>
Operating System : 
<ul>
<c:forEach var = "temp" items = "${student.operatingSystems}">
<li> ${temp} </li>
</c:forEach>
</ul>

</body>
</html>