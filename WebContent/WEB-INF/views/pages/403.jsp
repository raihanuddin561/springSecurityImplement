<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access denied</title>
</head>
<body>
	This page is not allowed for you!!!
	<br>
	Go to 
	<c:url var="homePage" value="/"></c:url>
	<a href="${homePage }">Home Page</a>
</body>
</html>