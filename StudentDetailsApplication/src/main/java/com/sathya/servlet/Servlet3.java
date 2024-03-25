package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session=request.getSession(false);
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<body bgcolor=green;>");
		writer.println("<h1>"+"Check your details"+"</h1>");
		writer.println("<pre>");
		writer.println("Your Name ="+session.getAttribute("studentname"));
		writer.println("Your Age ="+session.getAttribute("studentname"));
		writer.println("Your Qualification ="+session.getAttribute("studentname"));
		writer.println("Your Designation ="+session.getAttribute("studentname"));
		writer.println("Your Email ="+request.getParameter("email"));
		writer.println("Your Mobile ="+request.getParameter("mobile"));
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");*/
		
		Cookie[] cookies=request.getCookies();
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<body bgcolor=red;>");
		writer.println("<h1>"+"Check your details"+"</h1>");
		writer.println("<pre>");
		writer.println("Your Name ="+cookies[0].getValue());
		writer.println("Your Age ="+cookies[1].getValue());
		writer.println("Your Qualification ="+cookies[2].getValue());
		writer.println("Your Designation ="+cookies[3].getValue());
		writer.println("Your Email ="+request.getParameter("email"));
		writer.println("Your Mobile ="+request.getParameter("mobile"));
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
