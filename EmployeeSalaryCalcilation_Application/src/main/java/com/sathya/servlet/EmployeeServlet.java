package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step-1:read the data
		int id=Integer.parseInt(request.getParameter("EmpID"));
		String name=request.getParameter("EmpName");
		double bsal=Double.parseDouble(request.getParameter("EmpBasicSal"));
		
		//step-2:process the data
		double gross_sal,hra,da,pf;
		if(bsal >=50000)
		{
			hra=bsal*.30;
			da=bsal*.10;
			pf=bsal*.06;
			gross_sal=bsal+hra+da-pf;
		}
		else if(bsal<50000 && bsal>25000)
		{
			hra=bsal*.20;
			da=bsal*.05;
			pf=bsal*.03;
			gross_sal=bsal+hra+da-pf;
		}
		else
		{
			hra=bsal*.10;
			da=bsal*.03;
			pf=bsal*.02;
			gross_sal=bsal+hra+da-pf;
		}
		
		//step-3:render th response
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		
		writer.println("<html>");
		writer.println("<body bgcolor=yellow>");
		writer.println("<h1> Employee Total Info </h1>");
		writer.println(" <br>Employee ID :"+id);
		writer.println("<br> Employee Name :"+name);
		writer.println(" <br>Employee BasicSalary :"+bsal);
		writer.println("<br> Employee HRA :"+hra);
		writer.println(" <br>Employee DA :"+da);
		writer.println("<br> Employee PF :"+pf);
		writer.println("<br> Employee Gross_Salary :"+gross_sal);
		writer.println("</body>");
		writer.println("</html>");
	}
}
