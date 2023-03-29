<%@page import="dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
		
		<table border="1px solid black">
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Password</th>
					<th>Edit</th>
					<th>Delete</th>	
				
				</tr>	
		
		<%
		List<UserDTO> list =(List<UserDTO>) request.getAttribute("list");
		%>
		
		<%
		for(UserDTO dto : list){
		%>
		<tr>
			<td><%=dto.getName() %></td>
			<td><%=dto.getEmail() %></td>
			<td><%=dto.getMobile() %></td>
			<td><%=dto.getPassword() %></td>
			<td><a href="Edit.jsp?mob=<%=dto.getMobile()%>"><button>Edit</button></a></td>
			<td><a href="delete?mob=<%=dto.getMobile()%>"><button>Delete</button></a></td>
		</tr>
		<%
		}
		%>
		</table>
		
		
		
</body>
</html>