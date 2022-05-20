<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="Icon" type="image/x-icon" href="./favicon.ico">
</head>
<body>

	<% response.setHeader("Cache-control", "no-cache, no-store, must-revalidate"); %>
	<br>
	<br>
	<iframe width="560" height="315"
		src="https://www.youtube.com/embed/dYvr9RPfxlM" frameborder="0"
		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
		allowfullscreen></iframe>
	<br>
	<br> Welcome ${username}

	<br>
	<br>
	
	
	<form action="logout">
		<input type="submit" value="logout">
	</form>
</body>
</html>