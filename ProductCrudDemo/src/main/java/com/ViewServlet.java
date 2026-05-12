package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<a href='index.html'>Add Product</a>");
		
		List<Product> list =ProductAccess.getProducts();
		
		pw.print("<table border='1' width='100%'>");
		pw.print("<tr><th>Product_ID</th> <th>Product_Name</th> <th>Price</th> <th>Quality</th>  <th>Edit</th> <th>Delete</th></tr>");
		
		for(Product p:list) {
			pw.print("<tr><td>"+p.getProduct_id()+"</td> <td>"
		                       +p.getProduct_name()+"</td> <td>"
					           +p.getPrice()+"</td> <td>"
		                       +p.getQuality()+"</td> <td><a href='EditProduct?p_id="+p.getProduct_id()
		                       +"'>Edit</a></td><td><a href='DeleteProduct?p_id="
		                       +p.getProduct_id()+"'>Delete</a></td></tr>");
		}
		pw.print("</table>");
		pw.close();
	}

}
