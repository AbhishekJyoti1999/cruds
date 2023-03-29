<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%long mob=Long.parseLong(request.getParameter("mob")); 
UserDAO dao=new UserDAO(); 
UserDTO dto=dao.find(mob);
%>

<form action="update" method="post">
<h1>Update here....</h1>
Email : <input type="email" name="email" value="<%=dto.getEmail()%>"><br>
Mobile : <input type="number" name="mob" value="<%=dto.getMobile()%>"><br>
Name : <input type="text" name="name" value="<%=dto.getName()%>"><br>
Password : <input type="password" name="pwd" value="<%=dto.getPassword()%>"><br>
<button type="reset">Cancel</button>
<button type="submit">Update</button>
</form>

</body>
</html>