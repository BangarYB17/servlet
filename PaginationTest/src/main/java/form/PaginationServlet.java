package form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/PaginationServlet")
public class PaginationServlet extends HttpServlet {

    List<String> data = new ArrayList<>();

    @Override
    public void init() {
        for (int i = 1; i <= 30; i++) {
            data.add("Student " + i);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        int pageSize = 5;
        int pageNumber = 1;

        String pageparam = request.getParameter("page");

        if (pageparam != null) {
            pageNumber = Integer.parseInt(pageparam);
        }

        int start = (pageNumber - 1) * pageSize;
        int end = Math.min(start + pageSize, data.size());

        pw.println("<h2>Pagination Example</h2>");

        // Display students
        for (int i = start; i < end; i++) {
            pw.println(  data.get(i) + "<br>");
        }

        // Pagination links
        int totalPage = (int) Math.ceil((double) data.size() / pageSize);

        pw.println("<br>");
        for (int i = 1; i <=totalPage; i++) {
            pw.println("<a href='PaginationServlet?page=" + i + "'>" + i + "</a> ");
        }

        pw.close();
    }
}