package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductBillServlet")
public class ProductBillServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//step-1:read the data
			 int prodid=Integer.parseInt(request.getParameter("ProductId"));
			 String prodname=request.getParameter("ProductName");
			 double prodprice=Double.parseDouble(request.getParameter("ProductPrice"));
			 int prodqty=Integer.parseInt(request.getParameter("ProductQuantity"));
			
			//step-2:process the data
			 
			 double total_bill;
			 String discount;
			 double discount_amount = 0;
			 
			 total_bill=prodqty*prodprice;
			
			 
			if(total_bill < 1000)
			{
				discount="No Discount applied";
			}
			else if (total_bill > 1000 && total_bill <5000)
			{
				discount="5% discount";
				discount_amount=total_bill*.05;
				total_bill-=discount_amount;
			}
			else if (total_bill >=5000 && total_bill <10000)
			{
				discount="10% discount";
				discount_amount=total_bill*.10;
				total_bill-=discount_amount;
			}
			else
			{
				discount="15% discount";
				discount_amount=total_bill*.15;
				total_bill-=discount_amount;
			}
			
			//step-3:render tha data
			 response.setContentType("text/html");
			 PrintWriter writer=response.getWriter();
			 
			 writer.println("<html>");
			 writer.println("<body bgcolor=pink>");
			 writer.println("<br><br> ProductID is :"+prodid);
			 writer.println("<br><br> ProductName is : "+prodname);
			 writer.println("<br><br> ProductPrice is : "+prodprice);
			 writer.println("<br><br> ProductQuantity is : "+prodqty);
			 writer.println("<br><br> Discount you got : "+discount);
			 writer.println("<br><br> Discount money : "+discount_amount);
			 writer.println(" <br><br>TotalBillInvoice is :"+total_bill);
			 writer.println("</body>");
			 writer.println("</html>");
			 
	}
}
