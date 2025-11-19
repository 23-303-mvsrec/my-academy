import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class Validate extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    if (username.equals("john") && password.equals("john123")) {
        response.addCookie(new Cookie("login", "john"));
        System.out.println("Login Successful!!<br>");
        out.println("<a href='Times'> Click Here </a>");
    } else {
        out.println("<h1>Invalid Credentials</h1>");
    }
}
}
