<%@ page import="java.sql.*"%>
<html>
<head>
    <title>Table Data</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5 0%, #ACB6E5 100%);
            font-family: 'Roboto', sans-serif;
            min-height: 100vh;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .card {
            background: #fff;
            padding: 2rem 2.5rem;
            border-radius: 16px;
            box-shadow: 0 8px 32px rgba(44, 62, 80, 0.15);
            text-align: center;
            max-width: 800px;
            width: 100%;
        }
        h2 {
            margin-bottom: 1.2rem;
            color: #2d3e50;
            font-weight: 700;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 1.5rem;
        }
        th, td {
            padding: 0.75rem 1rem;
            border-bottom: 1px solid #e0e0e0;
            text-align: left;
        }
        th {
            background: linear-gradient(90deg, #74b9ff 0%, #81ecec 100%);
            color: #fff;
            font-weight: 700;
        }
        tr:nth-child(even) {
            background: #f7fafd;
        }
        tr:hover {
            background: #e3f2fd;
        }
        .error {
            color: #d63031;
            margin-top: 1rem;
            font-weight: 700;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>Table Data</h2>
        <%
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jsp303";
            conn = DriverManager.getConnection(url, "root", "");
            String tablename = request.getParameter("tablename");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + tablename);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
        %>
        <table>
            <tr>
            <% for (int i = 1; i <= columnCount; i++) { %>
                <th><%= rsmd.getColumnName(i) %></th>
            <% } %>
            </tr>
            <% while (rs.next()) { %>
            <tr>
                <% for (int i = 1; i <= columnCount; i++) { %>
                    <td><%= rs.getString(i) %></td>
                <% } %>
            </tr>
            <% } %>
        </table>
        <%
        } catch (Exception e) {
        %>
            <div class="error">Error: <%= e.getMessage() %></div>
        <%
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
        %>
            <div class="error">Error closing resources: <%= e.getMessage() %></div>
        <%
            }
        }
        %>
    </div>
</body>
</html>