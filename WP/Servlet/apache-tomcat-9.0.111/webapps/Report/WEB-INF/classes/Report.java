import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Report extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String rollno = req.getParameter("rollno");
        String ageStr = req.getParameter("age");
        String branch = req.getParameter("branch");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Report</title>");
        out.println("<style>");
        out.println("body {font-family: Arial, sans-serif; background: linear-gradient(to right, #d7e1ec, #f0f5f9);"
                + "display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;}");
        out.println(".report-box {background-color: white; padding: 30px 40px; border-radius: 15px; "
                + "box-shadow: 0 0 10px rgba(0,0,0,0.2); width: 400px;}");
        out.println("h2 {text-align: center; color: #003366;}");
        out.println("h3 {text-align: center;}");
        out.println("b {color: #333;}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='report-box'>");

        // If no parameters, show input form
        if (name == null) {
            out.println("<h2>Enter Student Details</h2>");
            out.println("<form method='get'>");
            out.println("Name: <input type='text' name='name'><br><br>");
            out.println("Roll No: <input type='text' name='rollno'><br><br>");
            out.println("Age: <input type='number' name='age'><br><br>");
            out.println("Branch: <input type='text' name='branch'><br><br>");
            out.println("Marks in 5 subjects:<br>");
            for (int i = 1; i <= 5; i++) {
                out.println("Subject " + i + ": <input type='number' name='m" + i + "'><br>");
            }
            out.println("<br><input type='submit' value='Generate Report'>");
            out.println("</form>");
        } else {
            int age = Integer.parseInt(ageStr);
            int marks[] = new int[5];
            boolean failed = false;
            StringBuilder failedSubs = new StringBuilder();

            for (int i = 0; i < 5; i++) {
                marks[i] = Integer.parseInt(req.getParameter("m" + (i + 1)));
                if (marks[i] < 35) {
                    failed = true;
                    failedSubs.append("Subject " + (i + 1) + " ");
                }
            }

            out.println("<h2>Student Report</h2>");
            out.println("<b>Name:</b> " + name + "<br>");
            out.println("<b>Roll No:</b> " + rollno + "<br>");
            out.println("<b>Age:</b> " + age + "<br>");
            out.println("<b>Branch:</b> " + branch + "<br><br>");

            if (failed) {
                out.println("<h3 style='color:red;'>Result: FAILED</h3>");
                out.println("<p style='color:red;'><b>Failed Subjects:</b> " + failedSubs + "</p>");
            } else {
                int total = 0;
                for (int m : marks) total += m;
                double avg = total / 5.0;
                double cgpa = avg / 9.5;
                out.println("<h3 style='color:green;'>Result: PASSED</h3>");
                out.println("<p><b>Average Marks:</b> " + avg + "<br>");
                out.println("<b>CGPA:</b> " + String.format("%.2f", cgpa) + "</p>");
            }

            out.println("<br><center><a href='form.html' "
                    + "style='text-decoration:none; background:#007BFF; color:white; padding:8px 15px; border-radius:6px;'>"
                    + "Back to Form</a></center>");
        }

        out.println("</div>");
        out.println("</body></html>");
    }
    }
