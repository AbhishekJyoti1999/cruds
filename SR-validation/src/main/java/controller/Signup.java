package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;
@WebServlet("/save")
public class Signup extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDTO dto=new UserDTO();
		dto.setEmail(req.getParameter("email"));
		dto.setName(req.getParameter("name"));
		dto.setPassword(req.getParameter("pwd"));
		dto.setMobile(Long.parseLong(req.getParameter("mob")));
		
//		res.getWriter().print("<h1>"+dto+"</h1>");
		
		UserDAO dao=new UserDAO();
		dao.save(dto);
		
		resp.getWriter().print("<h1>Account Created Successfully</h1>");
		
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
	
}
