
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>
<body>

	<div class="container">
		<br /> <br />

		<c:if test="${user != null }">
			<h2>Update Existing User</h2>
			<form action="update">
				<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				<div class="form-group">
					<label for="name">User Name</label> <input type="text"
						class="form-control" name="name"
						value="<c:out value='${user.name}' />" />
				</div>
				<div class="form-group">
					<label for="email">User Email</label> <input type="email"
						class="form-control" name="email"
						value="<c:out value='${user.email}' />" />
				</div>
				<div class="form-group">
					<label for="country">User Country</label> <input type="text"
						class="form-control" name="country"
						value="<c:out value='${user.country}' />" " />
				</div>

				<button type="submit" class="btn btn-secondary">Submit</button>
			</form>
		</c:if>

		<c:if test="${user == null }">
			<h2>Add User</h2>

			<form action="insert">
				<div class="form-group">
					<label for="name">User Name</label> <input type="text"
						class="form-control" name="name" />
				</div>
				<div class="form-group">
					<label for="email">User Email</label> <input type="email"
						class="form-control" name="email" />
				</div>
				<div class="form-group">
					<label for="country">User Country</label> <input type="text"
						class="form-control" name="country" />
				</div>

				<button type="submit" class="btn btn-secondary">Submit</button>
			</form>
		</c:if>


	</div>

</body>
</html>