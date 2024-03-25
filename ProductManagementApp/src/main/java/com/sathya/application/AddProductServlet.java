package com.sathya.application;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		
		String pId=request.getParameter("proId");
		String pName=request.getParameter("proName");
		double pPrice=Double.parseDouble(request.getParameter("proPrice"));
		String pBrand=request.getParameter("proBrand");
		String pMadIn=request.getParameter("proMadeIn");
		Date pMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date pExpDate=Date.valueOf(request.getParameter("proExpDate"));
		Part part1=request.getPart("proImage");
		InputStream inputStream1=part1.getInputStream();
		
		Part part2=request.getPart("proAudio");
		InputStream inputStream2=part2.getInputStream();
		
		Part part3=request.getPart("proVideo");
		InputStream inputStream3=part3.getInputStream();
		
		//converting inputStream into byte[]
		byte[] pImage=IOUtils.toByteArray(inputStream1);
		
		byte[] pAudio=IOUtils.toByteArray(inputStream2);
		
		byte[] pVideo=IOUtils.toByteArray(inputStream3);
		
		Product product=new Product();
		product.setProId(pId);
		product.setProName(pName);
		product.setProPrice(pPrice);
		product.setProBrand(pBrand);
		product.setProMadeIn(pMadIn);
		product.setProMfgDate(pMfgDate);
		product.setProExpDate(pExpDate);
		product.setProImage(pImage);
		product.setProAudio(pAudio);
		product.setProVideo(pVideo);
		
		ProductDao productDao=new ProductDao();
			int result=0;
			try {
				result = productDao.save(product);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(result==1) {
				//send result to productList.jsp for validation
				request.setAttribute("saveResult",result);
				RequestDispatcher dispatcher=request.getRequestDispatcher("productsList.jsp");
				dispatcher.forward(request, response);
			}
			else {
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter();
				writer.println("<html>");
				writer.println("<body>");
				writer.println("<h2> Data Insertion failed check the form once..."+result+"</h2>");
				writer.println("</body>");
				writer.println("</html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("addProducts.html");
				dispatcher.include(request, response);
			}
	}
}
