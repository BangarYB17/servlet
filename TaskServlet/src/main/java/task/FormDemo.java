package task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FormDemo
 */
@WebServlet("/FormDemo")
public class FormDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String age = request.getParameter("age");
		String education = request.getParameter("education");
		
		pw.println("<html><body>");
		pw.println("<h1> ***** Students Data *****</h1>");
		pw.println("<h2>Name: " +name+"<h2>");
		pw.println("<h2>city: " +city+"<h2>");
		pw.println("<h2>age: " +age+"<h2>");
		pw.println("<h2>education: " +education+"<h2>");
		pw.println("</body></html>");
		pw.close();
	}
}
