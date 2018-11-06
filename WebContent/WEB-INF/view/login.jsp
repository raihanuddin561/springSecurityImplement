<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload='document.f.username.focus();'>
	<h3>Login with username and password</h3>
	<form name='f' action = '${loginUrl}' method="post">
		<table>
			<tr>
				<c:if test="${param.error !=null }">
					<span style="color:red">Invalid Username or password</span>
				</c:if>
				<td>User</td>
				<td><input type="text" name="username" value=''></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" ></td>
			</tr>
			<tr>
				<td>Remember me:</td>
				<td><input type="checkbox" name="remember-me" checked="checked" ></td>
			</tr>
			<tr>
			<td><input type="submit" name="submit" value="login" ></td>
			</tr>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }" />
		</table>
	</form>
</body>
</html>