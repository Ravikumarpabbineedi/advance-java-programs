package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GenerateNumbersServlet")
public class GenerateNumbersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step-1:Read the data
		int sn=Integer.parseInt(request.getParameter("StartNumber"));
		int en=Integer.parseInt(request.getParameter("EndNumber"));
		String operation=request.getParameter("Operation");
		
		//step-2:process the data
		ArrayList<Integer> a=new ArrayList<>();
		
		switch (operation) {
		case "Even": for(int i=sn;i<=en;i++)
					{
						if(i%2 == 0) {
							a.add(i);
						}
					}
					break;
		case "Odd": for(int i=sn;i<=en;i++)
					{
						if(i%2 != 0) {
							a.add(i);
						}
					}
					break;
		case "Prime":
						boolean flag;
					for(int i=sn;i<=en;i++)
					{
						flag=false;
						for(int j=2;j<=i/2;j++) {
							if(i%j == 0) {
								flag=true;
								break;
							}
						}
						if(flag==false) {
							a.add(i);
						}
					}
					break;
		case "Perfect": for(int i=sn;i<=en;i++)
					{
						int sum=0;
						for(int j=1;j<i;j++) {
							if(i%j == 0) {
								sum+=j;
							}
						}
						if(sum == i) {
							a.add(i);
						}
					}
					break;
		case "Strong":int rem,temp,fact,sum;
					for(int i=sn;i<=en;i++)
					{
						sum=0;
						rem=0;
						temp=i;
						while(temp>0) {
							rem=temp%10;
							fact=1;
							while(rem>0) {
								fact*=rem;
								rem-=1;
							}
							sum+=fact;
							temp/=10;
						}
						if(sum==i) {
							a.add(i);
						}
					}
					break;
		case "Armstrong":int temp1,sum1,temp2,rem2,count=0;
						for(int i=sn;i<=en;i++)
						{
							sum1=0;
							temp1=i;
							count=0;
							while(temp1 > 0) {
								count+=1;
								temp1/=10;
							}
							temp2=i;
							while(temp2 > 0 ) {
								rem2=temp2%10;
								sum1+=Math.pow(rem2,count);
								temp2/=10;
							}
							if(sum1 == i) {
								a.add(i);
							}
						}
						break;
		}
		
		//step-3:render the data
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<body bgcolor=red>");
		writer.println("<br> The Given Operation is:"+" "+operation);
		writer.println("<br> The Given Operation result is:"+" "+a);
		writer.println("</body>");
		writer.println("</html>");
	}
}
