<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		Enter Name : <input type="text" name="fname"><br /> Enter Age
		: <input type="text" name="age"><br /> Enter Email : <input
			type="text" name="email"><br /> Enter Password : <input
			type="password" name="password"><br /> Gender : <input
			type="radio" name="gender" value="Male">
		&nbsp;&nbsp;&nbsp;&nbsp; 
		<input type="radio" name="gender"
			value="Feale"><br /> Hobbies : <input type="checkbox"
			name="hobby" value="reading" />Reading <input type="checkbox"
			name="hobby" value="browsing" />Browsing <input type="checkbox"
			name="hobby" value="gaming" />Gaming <input type="checkbox"
			name="hobby" value="Cooking" />Cooking <br /> Country : <select
			name="country">
			<option value="select">Select Country</option>
			<option value="INDIA">INDIA</option>
			<option value="USA">USA</option>
			<option value="UK">UK</option>
			<option value="AUSTRALIA">AUSTRALIA</option>
			<option value="GERMANY">GERMANY</option>
			<option value="OTHERS">OTHERS</option>
		</select><br />
		<br /> <input type="submit" name="register" value="Register Details" />

	</form>
	
		<%if(request.getParameter("register")!=null){%>
			<jsp:useBean id="user" class="com.to.User" scope="request"></jsp:useBean>
			<jsp:setProperty property="*" name="user"/>
			<jsp:forward page="RegisterServlet"></jsp:forward>
		<%}%>
</body>
</html>