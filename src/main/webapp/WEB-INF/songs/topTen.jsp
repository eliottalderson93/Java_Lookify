<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top Ten</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<div class = "header">
	<p>Top Ten Songs:</p>
	<a href = "/dashboard">Dashboard</a>
</div>
<div class = "hitbox">
<c:forEach items="${top10}" var="song">
	<p> ${song.rating} - <a href = "/songs/${song.id}">${song.title}</a> - ${song.artist}</p>
</c:forEach>
</div>
</body>
</html>