<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	if (session.getAttribute("email") == null) {
	response.sendRedirect("/front-end/login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="home.css">
<title>Edit</title>
</head>
<body>

	<form class="form-edit" action="edit">
			<textarea class="note-edit" id="content" name="content"><c:out value="${note.content}"/></textarea>
			<br><br> 
			<input class="btn-update" type="submit" value="update">
	</form>
</body>
</html>