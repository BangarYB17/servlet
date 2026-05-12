package form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class PaginationDemo
 */
@WebServlet("/PaginationDemo")
public class PaginationDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	List<String> data = new ArrayList<String>();

	//dummy data
	public void init() {
		for(int i=1;i<=50;i++) {
			data.add("Items"+ " "+i);		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int pageSize = 10;
		int pageNumber = 1;
		
		String  pageparam = request.getParameter("page"); //Reads page number from URL (<a>)
		 
		if(pageparam != null) {
			pageNumber = Integer.parseInt(pageparam); //If user clicks a page link → update pageNumber
		}
		
		int start =(pageNumber -1)*pageSize; //Page 1 → start=0, end=10
		int end = Math.min(start+pageSize, data.size());
		
		pw.println("<h2>Pagination Task</h2>");
		
		//display students
		for(int i =start ;i<end;i++) {
			pw.println(data.get(i)+"<br>");		 //Prints only current page data (10 items)
		}
		
		pw.print("<br>");
		
		int totalPage = (int) Math.ceil((double)data.size()/pageSize); //50 items / 10 per page = 5 pages
		
		//pagination links
		for(int i=1;i<=totalPage;i++) {
			pw.println("<a href='PaginationDemo?page="+ i +"'>"+ i +"</a>"); // Creates clickable links
		}
		pw.close();
	}

}
