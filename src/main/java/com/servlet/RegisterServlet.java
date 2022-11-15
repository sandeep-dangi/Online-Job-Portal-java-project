package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     
		try {
			
			String name=req.getParameter("name");
			String qua=req.getParameter("qua");
			String email=req.getParameter("email");
			String ps=req.getParameter("ps");
			
			UserDAO dao = new UserDAO(DBConnect.getConn());
			
			User u = new User(name,email,ps,qua,"User");
			boolean f = dao.addUser(u);
			
			HttpSession session = req.getSession();
			if(f)  {
				session.setAttribute("succMsg", "Registration Successfully");
				resp.sendRedirect("signup.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("signup.jsp");
			}
					
					
					
					
					
					
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	
}
