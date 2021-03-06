<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
<!-- Reference our style sheet -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
		
</head>	
<body>
	<div id = "wrapper">
		<div id = "container">
			<div id = "comtent">
			<!-- Put new button : Add customer -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd; return false;'"
				class="add-button"
			 />
			 
			
			 
				<!-- Add HTML tables here -->
				<table>
					<tr>
						<th>First name</th>
						<th>Last name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					 
					<!-- Loop over and print out customers -->
					<c:forEach var="tempCustomer" items="${customers}">
						
						<!-- Construct an update link with customer ID -->
						 <c:url var = "updateLink" value="/customer/showFormForUpdate">
						 	<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						 </c:url>
						 
						 <!-- Construct a delete link with customer ID -->
						 <c:url var = "deleteLink" value="/customer/delete">
						 	<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						 </c:url>
					 
						<tr>
							<td> ${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td>
							<td> <!-- Display update link -->
								<a href="${updateLink}">Update</a> 
								|
								<!-- Display delete link -->
								<a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer ?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>	
				</table>
			</div>
		</div>
	</div>
</body>
</html>