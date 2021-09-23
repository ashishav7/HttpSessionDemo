package com.comviva.web;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ResponseCache;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("login.html").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("useremail");
		String pass = request.getParameter("password");
		if(email!=null || pass!=null) {
			if(email.equals("admin@gmail.com") && pass.equals("admin@123")) {
				
				//create a new session
				HttpSession session = request.getSession(true);
				//session attribute
				session.setAttribute("email",email);
				session.setAttribute("token",UUID.randomUUID());

				out.println("<h3 style = 'color:green'> Login Successful </h3>");
			}
			else {
				out.println("<h3 style = 'color:red'> Login Failed! Invalid Creds </h3>");
			}
		}
		else {
			out.println("<h3 style = 'color:red'> Login Failed </h3>");
		}
	}

}
