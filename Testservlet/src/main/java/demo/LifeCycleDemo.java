package demo;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LifeCycleDemo
 */
@WebServlet("/LifeCycleDemo")
public class LifeCycleDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    String msg;
    public LifeCycleDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init method execute");
		msg = "Welcome";
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy method execute");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		pw.println("<html><body>");
//		pw.println(msg + " Yogeshwar Bangar");
//		pw.println("</body></html>");
//		
//		pw.close();
		if(request.getMethod().equalsIgnoreCase("GET"))
		{
			doGet(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POSt"))
		{
			doPost(request,response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
//		response.setContentType("text/htm");
		response.getWriter().println("Request Handled by doget()");
		
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.getWriter().println("Request Handled by doPost()");
	}

}
