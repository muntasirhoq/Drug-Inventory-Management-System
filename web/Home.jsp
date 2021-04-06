<%-- 
    Document   : Home.jsp
    Created on : Nov 19, 2016, 3:38:10 PM
    Author     : samsung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("username");
            if(username==null)
            {
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
            }
        %>
        <form method="post" action="Shipment.jsp">
            <input type="submit" value="Shipment">
        </form>
        </br>
        <form method="post" action="Purchase.jsp">
            <input type="submit" value="Purchase">
        </form>
        </br>
        <form method="post" action="Medicine.do">
            <input type="submit" value="Medicine">
        </form>
        </br>
        <form method="post" action="Company.do">
            <input type="submit" value="Company">
        </form>
        </br>
        <form method="post" action="Worker.do">
            <input type="submit" value="Worker">
        </form>
        </br>
        <form method="post" action="Inventory.do">
            <input type="submit" value="Inventory">
        </form>
        </br>
        <form method="post" action="Client.do">
            <input type="submit" value="Client">
        </form>
        </br>
        <form method="post" action="index.html">
            <input type="submit" value="Log Out">
        </form>
        
    </body>
</html>