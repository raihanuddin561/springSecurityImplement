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
	You are not allowed for this page.
	Return
	<c:url var="homePage" value="/"></c:url>
	 <a href="${homePage}" >homepage</a>
</body>
</html>