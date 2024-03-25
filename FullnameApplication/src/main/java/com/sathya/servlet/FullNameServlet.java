package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FullNameServlet")
public class FullNameServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//step1
			String firstname=request.getParameter("FirstName");
			String middlename=request.getParameter("MiddleName");
			String lastname=request.getParameter("LastName");
			
			
			//step 2
			String fullname;
			fullname=firstname+" "+middlename+" "+lastname;
			
			//step  3
			PrintWriter writer=response.getWriter();
			response.setContentType("text/html");
			
			writer.println("<html>");
			writer.println("<h1>FullName is:</h1>"+fullname);
			writer.println("</html>");
	}
}
