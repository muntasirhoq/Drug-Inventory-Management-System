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
        <title>JSP Inventory</title>
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
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
        </br>
        <form method="post" action="SearchInventory.jsp">
            <input type="submit" value="Search Inventory">
        </form>
        </br>
        <form method="post" action="ViewInventory.jsp">
            <input type="submit" value="View Inventory">
        </form>
        </br>
        
    </body>
</html>