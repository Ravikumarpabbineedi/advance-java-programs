package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step-1:from the request object read the data
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		long mobno=Long.parseLong(request.getParameter("moblieno"));
		String mail=request.getParameter("email");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String country=request.getParameter("country"); 
		String comments=request.getParameter("comments");
		
		//to read multiple values from the request object we have to use "getParameterValues" method
		
		String[] quals=request.getParameterValues("qualification");
		String[] language=request.getParameterValues("Languages");
		
		//step-2:process the data 
		//String array type cannot displayed on web browser so it reads only in string form 
		//so we have to convert all values into one string using "String.join("symbol",string array object ref.)"
		
		String q=String.join(",", quals);
		String l=String.join("-", language);
		
		//step-3:Render the response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<h1> Registration Successfull</h1>");
		writer.println("Your Name :"+name+"<br>");
		writer.println("Your Password :"+password+"<br>");
		writer.println("Your MobileNumber :"+mobno+"<br>");
		writer.println("Your Email :"+mail+"<br>");
		writer.println("Your Date Of Birth :"+dob+"<br>");
		writer.println("Your Gender :"+gender+"<br>");
		writer.println("Your Country :"+country+"<br>");
		writer.println("Your Qualification :"+q+"<br>");
		writer.println("Your Languages :"+l+"<br>");
		writer.println("Your Comments :"+comments);
		writer.println("</body>");
		writer.println("</html>");
	}
}
