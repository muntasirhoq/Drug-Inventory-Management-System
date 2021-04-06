<%-- 
    Document   : SearchInventory
    Created on : Dec 20, 2016, 1:30:09 AM
    Author     : Sifat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medicine</title>
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
        
        <h1>Search a Medicine</h1>
        <form method="post" action="SearchInventoryByMedicineName.do">
            Medicine Name<input type="text" name="medicineName" /><input type="submit" value="Search" />
        </form>
        </br> 
        <form method="post" action="SearchInventoryByGenericName.do">
            Generic Name<input type="text" name="genericName" /> <input type="submit" value="Search" />
        </form>
        </br>
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
        
    </body>
</html>
