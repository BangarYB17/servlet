package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<h1>Update Products</h1>");
		String pid = request.getParameter("p_id");
		int p_id = Integer.parseInt(pid);
		
		Product p = ProductAccess.getProductsById(p_id);
		pw.print("<form action='EditProduct2' method='get'>");
		
		pw.print("<table>");
		pw.print("<tr> <td>Product ID: </td> <td><input type='hidden' name='p_id' value='"+p.getProduct_id()+"'></td></tr>");
		pw.print("<tr><td>Product Name: </td> <td><input type='text' name='p_name' value='"+p.getProduct_name()+"'></td></tr>");
		pw.print("<tr><td>Price: </td> <td><input type='number' name='price' value='"+p.getPrice()+"'></td></tr>");
		pw.print("<tr><td>Quality</td><td>");
		pw.print("<select name='quality' style='width:100px'>");
		pw.print("<option>Excellent</option>");
		pw.print("<option>Good</option>");
		pw.print("<option>Average</option>");
		pw.print("<option>Bad</option>");
		pw.print("</select></td></tr>");
		
		pw.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'></td></tr>");
		pw.print("</table>");
		pw.print("</form>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
