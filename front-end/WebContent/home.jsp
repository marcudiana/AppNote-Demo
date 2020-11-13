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
<title>Home</title>
</head>
<body>
	<form action="add" method="post">
		<div id="modal" class="modal">
			<span class="close">&times;</span>
			<div class="modal-content">
				<input class="input-note input-name-note" type="text" name="name"
					placeholder="Name" required>
				<textarea class="input-note input-content-note" name="content"></textarea>
				<div class="checkbox">
					<c:forEach items="${tags}" var="tags">
						<input class="tag-checkbox" type="checkbox" name="tag" id="tag1">
						<label for="tag1"><c:out value="${tags.nameTag}" /></label>
						<br>
					</c:forEach>
				</div>
				<button class="btn-submit" type="submit" name="add">Add
					note</button>
			</div>
		</div>
	</form>

	<div class="container-search-btn">
		<input type="text" placeholder="Search...">
		<div class="search"></div>
		<button id="js-add" class="add-btn">
			<i class="fa fa-plus plus"></i>
		</button>
	</div>
	<div class="note-list">
		<table>
			<tbody>
				<c:forEach items="${notes}" var="notes">
					<tr>
						<td class="td-design">
							<div class="note-content">
								<i class="fa fa-folder folder-icon"></i>
								<c:out value="${notes.nameNote}" />
							</div>
							<div class="note-toolbox">
								<form class="btn-form" action="edit" method="post">
									<button class="btn-note">edit</button>
									<input name="idNote" type="hidden" value="${notes.idNote}">
								</form>
								<form class="btn-form" action="delete" method="post">
									<button class="btn-note">delete</button>
									<input name="idNote" type="hidden" value="${notes.idNote}">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script src="main.js"></script>
</body>
</html>
