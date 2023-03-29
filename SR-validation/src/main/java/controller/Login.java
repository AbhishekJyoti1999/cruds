package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;

@WebServlet("/Login")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String ep=req.getParameter("ep");
		String password=req.getParameter("pwd");
		
		UserDAO dao=new UserDAO();
		
		try {
		long mob=Long.parseLong(ep);
		UserDTO dto=dao.login(mob);		
		if(dto==null)
		{
			resp.getWriter().print("<h1>Invalid Mobile Number</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else {
			if(dto.getPassword().equals(password))
			{
				resp.getWriter().print("<h1>Login Success</h1>");
				req.setAttribute("list", dao.fetchAll());
				req.getRequestDispatcher("Home.jsp").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1>Invalid Password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
		}
		catch (NumberFormatException e) {
			String email=ep;
//			resp.getWriter().print("<h1>You entered email</h1>");
			UserDTO dto=dao.login(email);		
			if(dto==null)
			{
				resp.getWriter().print("<h1>Invalid email Id</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
			else {
				if(dto.getPassword().equals(password))
				{
					resp.getWriter().print("<h1>Login Success</h1>");
					req.setAttribute("list", dao.fetchAll());
					req.getRequestDispatcher("Home.jsp").include(req, resp);
				}
				else {
					resp.getWriter().print("<h1>Invalid Password</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
			}
		}
		
	}
}
