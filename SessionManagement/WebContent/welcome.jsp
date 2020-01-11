<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("user")==null)
{
	response.sendRedirect("login.jsp");
}
%>
<h1>Welcome ${user}</h1>
<br><br><br>
<a href="logout">Logout</a>
</body>
</html>