<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<h3>Submit user information here</h3>
	<hr>
	<table>
		<form:form action="addUser" modelAttribute="user">
			<tr>
				<td>Username</td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" type="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Submit" />
				</td>
			</tr>
		</form:form>
	</table>
	
	<c:url var="logoutUrl" value="/"></c:url>
	<form action="${logoutUrl }" method="post">
		<input type="submit" value="Logout"/>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
	</form>
</body>
</html>