package form;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletOne
 */
@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			String name = request.getParameter("username");
			String pass = request.getParameter("password");
			
			if(pass.equals("abc@123")) {
				RequestDispatcher rd = request.getRequestDispatcher("ServletTwo");
				rd.forward(request, response);
			}else {
				pw.print("Sorry! Incorrect Password");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
