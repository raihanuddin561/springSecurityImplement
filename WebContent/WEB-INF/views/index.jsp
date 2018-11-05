<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
	<h1>This is Home page</h1>
	<c:url var="addUser" value="/addUser"></c:url>
	<h3><a href="${addUser }">Add User</a></h3>
	<hr>
	<table border="1">
		<tr>
			<th>User ID</th>
			<th>User Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var = "temp" items="${user }">
			<tr>
				<td>${temp.userid }</td>
				<td>${temp.username }</td>
				<td>${temp.email }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>