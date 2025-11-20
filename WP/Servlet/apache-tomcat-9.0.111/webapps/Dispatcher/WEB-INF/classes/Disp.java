import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Disp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = (String) request.getAttribute("username");
        if (username == null) {
            username = request.getParameter("username");
        }

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Welcome</title></head><body>");
        out.println("<h1>Welcome, " + (username != null ? escapeHtml(username) : "Guest") + "!</h1>");
        out.println("<p>You have successfully logged in.</p>");
        out.println("</body></html>");
    }

    private String escapeHtml(String s) {
        if (s == null) return null;
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}

