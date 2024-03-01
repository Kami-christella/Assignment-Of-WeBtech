package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ControllerClass;


public class FirstPage extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		String id  = UUID. randomUUID().toString();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		ControllerClass cs = new ControllerClass();
		try {

	            if(username !=null && password !=null) {
	   			 Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtech2?useSSL=false", "root", "");
	            	String returned = cs.saveUser(username, password);
	    			PrintWriter out = res.getWriter();
	    			res.setContentType("text/html");
	    			out.println("<html><body>");
	    			out.println("<h1> The User is saved successful </h1>");
	    			out.println("<a href=\"login.html\">Click here to Login</a>");
	    			out.println("</body></html>");
	    			 connection.close();
	            } else {
	            	PrintWriter out = res.getWriter();
	            	out.println("<h1> Please provide the correct username and password </h1>");
	            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
