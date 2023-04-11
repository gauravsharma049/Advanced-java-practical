package practical5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Practical5Servlet")
public class Practical5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Practical5Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		  
		 
		pw.println("<html><body>");  
		pw.println("<h1>Welcome to servlet</h1>");  
		pw.println("</body></html>");  
		  
		pw.close();
	}


}
