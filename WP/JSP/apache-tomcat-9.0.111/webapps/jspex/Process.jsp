<jsp:useBean id="p" class="ex.Product" scope="request" />
<jsp:setProperty name="p" property="*" />
<html>
<body>
<h2>Product Report</h2>
Product ID: <jsp:getProperty name="p" property="pid" /><br>
Price: <jsp:getProperty name="p" property="price" /><br>
Quantity: <jsp:getProperty name="p" property="qty" /><br>
Discount %: <jsp:getProperty name="p" property="disc" /><br>
Final Amount after discount: <%= p.getFinalPrice() %><br>
</body>
</html>