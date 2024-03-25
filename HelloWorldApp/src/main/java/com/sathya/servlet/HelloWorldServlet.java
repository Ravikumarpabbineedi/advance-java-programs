package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		
		writer.println("<html>");
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<th> NAME </th>");
		writer.println("<th> MARKS </th>");
		writer.println("<th> GRADE </th>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td> Ravi </td>");
		writer.println("<td> 128 </td");
		writer.println("<td> A+ </td>");
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("<h1>Welcome to Sathya Tech<h1>");
		writer.println("<h2>Welcome to WebApplication<h2>");
		writer.println("<h3>Good morning to Ratan Sir<h3>");
		writer.println("</html>");
		
	}

	
}
