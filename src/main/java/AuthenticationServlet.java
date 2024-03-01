import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationServlet extends HttpServlet {
	
	

    // Update these values with your database information
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/webtech2?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Auca@2023";

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("password");
        PrintWriter out = res.getWriter();

        if (username != null && password != null) {
            if (authenticateUser(username, password)) {
                res.sendRedirect("Form.html"); // Redirect to another page on success
            } else {
                res.setContentType("text/html");
                out.println("Your username or password is incorrect");
                RequestDispatcher rd = req.getRequestDispatcher("/login.html");
                rd.include(req, res);
            }
        }
    }

    private boolean authenticateUser(String username, String password) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);

            // Prepare a SQL query to check if the username and password match
            String query = "SELECT * FROM user WHERE username=? AND password=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if any result is returned
                return resultSet.next();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a real-world application
            return false;
        }
    }
}
