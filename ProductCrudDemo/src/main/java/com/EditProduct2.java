package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EditProduct2
 */
@WebServlet("/EditProduct2")
public class EditProduct2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct2() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
	
		int id = Integer.parseInt(request.getParameter("p_id"));
		String name = request.getParameter("p_name");
		float price = Float.parseFloat(request.getParameter("price"));
		String quality = request.getParameter("quality");
		
		Product p = new Product();
		p.setProduct_id(id);
		p.setProduct_name(name);
		p.setPrice(price);
		p.setQuality(quality);
		
		int status = ProductAccess.update(p);
		if(status >0) {
			response.sendRedirect("ViewServlet");
		}else {
			pw.print("Sorry! Unable to edit record");
		}
		pw.close();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
