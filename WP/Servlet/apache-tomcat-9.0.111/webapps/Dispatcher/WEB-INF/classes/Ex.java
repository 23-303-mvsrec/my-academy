import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String validUser = "admin";
        String validPass = "secret";

        if (username != null && password != null
                && username.equals(validUser) && password.equals(validPass)) {

            request.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("/Disp");
            rd.forward(request, response);
        } else {
            out.println("<html><body>");
            out.println("<p style='color:red; font-weight:bold;'>Invalid username or password. Please try again.</p>");
            RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            rd.include(request, response);
            out.println("</body></html>");
        }
    }
}

