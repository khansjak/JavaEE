
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
		<br/>
		<br/>
		<h2>Add New User</h2>
		<form action="insertUser">
		  <div class="form-group">
		    <label for="name">User</label>
		    <input type="text" class="form-control" name="name">
		    
		  </div>
		  <div class="form-group">
		    <label for="email">Email</label>
		    <input type="email" class="form-control" name="email">
		  </div>
		  
		  <div class="form-group">
		    <label for="country">Country</label>
		    <input type="text" class="form-control" name="country">
		  </div>
		  
		  
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>	

</body>
</html>