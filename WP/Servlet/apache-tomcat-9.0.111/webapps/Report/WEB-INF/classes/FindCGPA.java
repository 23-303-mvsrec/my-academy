import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class FindCGPA extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        
        String name = req.getParameter("t1");
        String rollno = req.getParameter("t2");
        String age = req.getParameter("t3");
        String branch = req.getParameter("t4");

        
        double[] marks = new double[5];
        for (int i = 0; i < 5; i++) {
            marks[i] = Double.parseDouble(req.getParameter("t" + (i + 5)));
        }

        
        double total = 0;
        for (int i = 0; i < 5; i++) {
            total += marks[i];
        }
        double avg = total / 5.0;
        double cgpa = avg / 10.0;

        
        StringBuilder failed = new StringBuilder();
        int failedCount = 0;
        for (int i = 0; i < 5; i++) {
            if (marks[i] < 35) {
                failed.append("Subject ").append(i + 1).append(", ");
                failedCount++;
            }
        }

       
        pw.println("<html><head><title>Student Report</title>");
        pw.println("<style>");
        pw.println("body{font-family:Arial;margin:40px;background-color:#f8f9fa;}");
        pw.println(".report{background:#fff;padding:20px;border-radius:8px;"
                + "box-shadow:0 0 10px rgba(0,0,0,0.1);width:400px;}");
        pw.println(".passed{color:green;font-weight:bold;}");
        pw.println(".failed{color:red;font-weight:bold;}");
        pw.println("</style></head><body>");
        pw.println("<div class='report'>");

        pw.println("<h2>Student Report</h2>");
        pw.println("<p><b>Name:</b> " + name + "</p>");
        pw.println("<p><b>Roll No:</b> " + rollno + "</p>");
        pw.println("<p><b>Age:</b> " + age + "</p>");
        pw.println("<p><b>Branch:</b> " + branch + "</p>");

        pw.println("<p><b>Marks:</b> ");
        for (int i = 0; i < 5; i++) {
            pw.print(marks[i]);
            if (i < 4) pw.print(", ");
        }
        pw.println("</p>");

       
        if (failedCount == 0) {
            pw.println("<p><b>Average:</b> " + String.format("%.2f", avg) + "</p>");
            pw.println("<p><b>CGPA:</b> " + String.format("%.2f", cgpa) + "</p>");
            pw.println("<p class='passed'>Result: Passed </p>");
        } else {
            pw.println("<p class='failed'>Result: Failed </p>");
            pw.println("<p class='failed'>Failed in: "
                    + failed.substring(0, failed.length() - 2) + "</p>");
        }

        pw.println("</div></body></html>");
        pw.close();
    }
}

