<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${query_text}</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<div class = "header">
	<p>Songs by Artist: ${query_text}</p>
	<form action = "/search" method = "post" >
		<input type = "text" name = "search" value = "${query_text}">
		<input type = "submit" value = "New Search"/>
	</form>
	<a href = "/dashboard">Dashboard</a>
	</div>
	<div class = "song_table">
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${this_query}" var="song">
			<tr>
				<a href = "/songs/${song.id}"><td>${song.title}</td></a>
				<td>${song.rating}</td>
				<td>
					<form action = "/delete/${song.id}" method = "post">
						<input type = "hidden" name = "_method" value = "delete">
						<button>Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>
</div>
</body>
</html>