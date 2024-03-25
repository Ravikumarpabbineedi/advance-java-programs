package com.sathya.application;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updatedProId=request.getParameter("proId");
		String updatedProName=request.getParameter("proName");
		double updatedProPrice=Double.parseDouble(request.getParameter("proPrice"));
		String updatedProBrand=request.getParameter("proBrand");
		String updatedProMadeIn=request.getParameter("proMadeIn");
		Date updatedProMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date updatedProExpDate=Date.valueOf(request.getParameter("proExpDate"));
		
		Product product=new Product();
		
		product.setProId(updatedProId);
		product.setProName(updatedProName);
		product.setProPrice(updatedProPrice);
		product.setProBrand(updatedProBrand);
		product.setProMadeIn(updatedProMadeIn);
		product.setProMfgDate(updatedProMfgDate);
		product.setProExpDate(updatedProExpDate);
		
		Part newPart1=request.getPart("newProImage"); 
		
		if(newPart1 !=null && newPart1.getSize()>0) {
			InputStream inputStream1=newPart1.getInputStream();
			byte[] newProImage=IOUtils.toByteArray(inputStream1);
			product.setProImage(newProImage);
		}
		else {
			String str1=request.getParameter("existingProImage");
			byte[] existingProImage=Base64.getDecoder().decode(str1);
			product.setProImage(existingProImage);
		}
//		
//		Part newPart2=request.getPart("newProAudio");
//		
//		if(newPart2 !=null && newPart2.getSize()>0) {
//			InputStream inputStream2=newPart2.getInputStream();
//			byte[] newProAudio=IOUtils.toByteArray(inputStream2);
//			product.setProAudio(newProAudio);
//		}
//		else {
//			String str2=request.getParameter("existingProAudio");
//			byte[] existingProAudio=Base64.getDecoder().decode(str2);
//			product.setProAudio(existingProAudio);
//		}
//		
//		Part newPart3=request.getPart("newProVideo");
//		
//		if(newPart3 !=null && newPart3.getSize()>0) {
//			InputStream inputStream3=newPart3.getInputStream();
//			byte[] newProVideo=IOUtils.toByteArray(inputStream3);
//			product.setProVideo(newProVideo);
//		}
//		else {
//			String str3=request.getParameter("existingProVideo");
//			byte[] existingProVideo=Base64.getDecoder().decode(str3);
//			product.setProVideo(existingProVideo);
//		}
		
			ProductDao productDao=new ProductDao();
			
			int result=productDao.updateById(product);
			if(result==1) {
				request.setAttribute("result", result);
				RequestDispatcher dispatcher=request.getRequestDispatcher("productsList.jsp");
				dispatcher.forward(request, response);
			}
			else {
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter();
				writer.println("<html>");
				writer.println("<body>");
				writer.println("<h2> Data updation failed check once..."+result+"</h2>");
				writer.println("</body>");
				writer.println("</html>");
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("editForm.jsp");
				dispatcher.include(request, response);
			}
	}
}
