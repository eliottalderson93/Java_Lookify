<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Song</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<a href = "/dashboard">Dashboard</a>
<form:form method = "post" action = "/dashboard" modelAttribute = "songs">
	<p>
        <form:label path="title">Title: </form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="artist">Artist: </form:label>
        <form:errors path="artist"/>
        <form:textarea path="artist"/>
    </p>
    <p>
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>
        <form:input type = "number" path="rating"/> <!-- see docs for further number specification -->
    </p>   
    <input type="submit" value="Add Song"/>
</form:form>
</body>
</html>