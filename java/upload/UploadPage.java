package upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ControllerClass;

public class UploadPage extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String email = req.getParameter("email");
        byte[] picture = req.getParameter("picture").getBytes(); // Changed to byte[]
        byte[] document = req.getParameter("document").getBytes(); // Changed to byte[]

        ControllerClass cs = new ControllerClass();
        try {
            if (email != null && picture != null && document != null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtech2?useSSL=false", "root", "");
                String returned = cs.saveInfo(email, picture, document);
                PrintWriter out = res.getWriter();
                res.setContentType("text/html");
                out.println("<html><body>");
                out.println("<h1> The Student Information is saved successfully </h1>");
                out.println("<a href=\"index.html\">Click here to Go Back To dashboard</a>");
                out.println("</body></html>");
                connection.close();
                out.println(returned);
            } else {
                PrintWriter out = res.getWriter();
                out.println("<h1> Please provide the correct username, picture, and document </h1>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
