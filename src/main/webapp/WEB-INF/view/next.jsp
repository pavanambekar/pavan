<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%--   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Welcome ${username}
	<br>
	<br>
	<% response.setHeader("Cache-control", "no-cache, no-store, must-revalidate"); %>
	<br>
	<br>
	<a href="video">click here for video</a>
	<br>
	<br>
	<form action="logout">
		<input type="submit" value="logout">
	</form>

</body>
</html>