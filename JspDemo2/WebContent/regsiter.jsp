<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		Enter Name :<input type="text"><br /> Enter Age :<input
			type="text" name="age"><br /> Enter email : <input
				type="text" name="email"><br /> Enter password :<input
					type=" name="password"><br /> Gender :<input type="radio"
						name="gender" value="Male">Male <input type="radio"
							name="gender" value="Female">Female <br /> Hobbies :<input
								type="checkbox" name="hobby" value="Reading" />Reading <input
								type="checkbox" name="hobby" value="Gaming" />Gaming <input
								type="checkbox" name="hobby" value="browsing" />Browsing <input
								type="checkbox" name="hobby" value="cookinh" />Cooking <br />
								Country :<select name="country">
									<option value="INDIA">INDIA</option>
									<option value="USA">USA</option>
									<option value="UK">UK</option>
									<option value="OTHERS">OTHERS</option>
							</select> <br /> <input type="submit" name="register"
								value="Register Details" /> <%
 	if (request.getParameter("register") != null) {
 %>
								<jsp:useBean id="user" class="com.to.User" scope="request"></jsp:useBean>
								<jsp:setProperty property="*" name="user" /> <jsp:forward
									page="RegisterServlet"></jsp:forward> <%}%>
	</form>

</body>
</html>