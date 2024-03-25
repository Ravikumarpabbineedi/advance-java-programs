package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			//step-1:Read the data
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			//step-2:Process the data
			String status;
			if(username.equals("sathya") && password.equals("sathya@123"))
			{
				status="Login Successfull...";
			}
			else
			{
				status="Login Failed...";
			}
			
			//step-3:Render the data
			PrintWriter writer=response.getWriter();
			response.setContentType("text/html");
			
			writer.println("<html>");
			writer.println("<h1> Login Status...</h1>"+status);
			writer.println("</html>");
	}
}
