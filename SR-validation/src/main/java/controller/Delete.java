package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;

@WebServlet("/delete")
public class Delete extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	long mob=Long.parseLong(req.getParameter("mob"));
	UserDAO dao=new UserDAO();
	
	 UserDTO dto=dao.find(mob);
	 
	 dao.delete(dto);
	 
	 resp.getWriter().print("<h1> Data Deleted Successfully</h1>");
	 
	 req.setAttribute("list", dao.fetchAll());
	 req.getRequestDispatcher("Home.jsp").include(req, resp);
	 
	 
}
}
