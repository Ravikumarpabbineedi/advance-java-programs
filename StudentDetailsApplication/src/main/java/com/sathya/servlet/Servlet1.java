package com.sathya.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String studentname=request.getParameter("studentname");
		int age=Integer.parseInt(request.getParameter("age"));
		
		//
		
		HttpSession session=request.getSession();
		
		//
		session.setAttribute("studentname", studentname);
		session.setAttribute("age",age);
		
		//
		RequestDispatcher dispatcher=request.getRequestDispatcher("Form2.html");
		
		//
		dispatcher.forward(request, response);*/
		
		String studentname=request.getParameter("studentname");
		String age=request.getParameter("age");
		
		Cookie cookie1=new Cookie("studentname",studentname);
		Cookie cookie2=new Cookie("age",age);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("Form2.html");
		
		dispatcher.forward(request, response);
	}

}
