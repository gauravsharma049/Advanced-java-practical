package practical6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Practical6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String url = "jdbc:mysql://localhost:3306/employee";
	private String username = "root";
	private String password = "root";
	private Connection con;
    public Practical6Servlet() {
        super();
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(this.url, this.username, this.password);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = "select * from emp";
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			pw.println("<html>\r\n"
					+ "<style>\r\n"
					+ "table, th, td {\r\n"
					+ "  border:1px solid black;\r\n"
					+ "}\r\n"
					+ "</style>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<h2>Employee Table</h2>\r\n"
					+ "\r\n"
					+ "<table style=\"width:50%\">\r\n"
					+ "  <tr>\r\n"
					+ "    <th>Emp Id</th>\r\n"
					+ "    <th>Name</th>\r\n"
					+ "    <th>Age</th>\r\n"
					+ "    <th>Designation</th>\r\n"
					+ "    <th>Salary</th>\r\n"
					+ "  </tr>");
			while(rs.next()) {
				pw.println("<tr>\r\n"
						+ "    <td>"+rs.getInt(1)+"</td>\r\n"
						+ "    <td>"+rs.getString(2)+"</td>\r\n"
						+ "    <td>"+rs.getInt(3)+"</td>\r\n"
						+ "    <td>"+rs.getString(4)+"</td>\r\n"
						+ "    <td>"+rs.getInt(5)+"</td>\r\n"
						+ "  </tr>");
			}
			pw.println("  \r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "");
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
