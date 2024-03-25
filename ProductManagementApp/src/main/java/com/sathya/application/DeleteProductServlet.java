package com.sathya.application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteProductServlet")
@MultipartConfig
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String proId=request.getParameter("proId");
			ProductDao productDao=new ProductDao();
			
			int result=0;
			try {
				result = productDao.deleteById(proId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(result==1) {
				request.setAttribute("deleteResult",result);
				RequestDispatcher dispatcher=request.getRequestDispatcher("productsList.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("deleteResult",result);
				RequestDispatcher dispatcher=request.getRequestDispatcher("productsList.jsp");
				dispatcher.forward(request, response);
			}
	}
}
