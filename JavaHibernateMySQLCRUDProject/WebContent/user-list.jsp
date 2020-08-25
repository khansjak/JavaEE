<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>mail</th>
			<th>Country</th>

		</tr>		
		</thead>
		<tbody>
			<c:forEach var="user" items="${listUser }">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.mail}" /></td>
					<td><c:out value="${user.country}" /></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>