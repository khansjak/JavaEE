<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<br /> <br /> <a href="new" class="btn btn-secondary">Add New
			User</a> <br />
		<br />

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Country</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${listUser}">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.country}" /></td>
						<td><a href="edit?id=<c:out value='${user.id}' />"
							class="btn btn-outline-primary">Edit</a> <a
							href="delete?id=<c:out value='${user.id}' />"
							class="btn btn-outline-danger">Delete</a></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>


	</div>
</body>
</html>