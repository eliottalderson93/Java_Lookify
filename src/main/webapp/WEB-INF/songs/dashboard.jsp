<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Songs</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<div class = "header">
	<a href = "/songs/new"> Add New</a>
	<a href= "/search/topTen">Top Songs</a>
	<form action = "/search" method = "post">
		<input name = "artist" type = "text">
		<input type = "submit" value = "Search Artists">
	</form>
</div>
<div class = "song_table">
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${songs}" var="song">
			<tr>
				<td><a href = "/songs/${song.id}">${song.title}</a></td>
				<td>${song.rating}</td>
				<td>
					<form action = "/delete/${song.id}" method = "post">
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