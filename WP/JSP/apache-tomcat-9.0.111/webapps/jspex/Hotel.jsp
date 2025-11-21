<%@ page import="java.util.*" %>
<%
String name = request.getParameter("name");
String mobile = request.getParameter("mobile");
int guests = Integer.parseInt(request.getParameter("guests"));
String roomType = request.getParameter("roomType");
int days = Integer.parseInt(request.getParameter("days"));
String boarding = request.getParameter("boarding");
int pricePerDay = roomType.equals("Economy") ? 1500 : roomType.equals("Regular") ? 2000 : roomType.equals("Premium") ? 3000 : 0;
int total = pricePerDay * days;
%>
<html>
<head>
    <title>Hotel Booking Summary</title>
    <style>
        table { border-collapse: collapse; width: 50%; }
        th, td { border: 1px solid #ccc; padding: 10px; }
        th { text-align: left; background-color:rgb(107, 124, 124); color:rgb(255, 255, 255); }
        h1 { color: #3c5555; }
    </style>
</head>
<body>
    <center>
    <h1>Hotel Booking Summary</h1>
    <table>
        <tr><th>Name</th><td><%= name %></td></tr>
        <tr><th>Mobile Number</th><td><%= mobile %></td></tr>
        <tr><th>Number of Guests</th><td><%= guests %></td></tr>
        <tr><th>Room Type</th><td><%= roomType %></td></tr>
        <tr><th>Number of Days</th><td><%= days %></td></tr>
        <tr><th>Boarding Date</th><td><%= boarding %></td></tr>
        <tr><th>Total Cost</th><td><%= total %></td></tr>
    </table>
    </center>
</body>
</html>