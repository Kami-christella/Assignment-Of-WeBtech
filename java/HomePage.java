import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet {

	
	public void service(HttpServletRequest req,
			HttpServletResponse res) throws IOException {
		PrintWriter out  = res.getWriter();
		res.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1>Welcome to home Page </h1>"+req.getParameter("userName"));
		out.println("</body></html>");
		
	}
}
