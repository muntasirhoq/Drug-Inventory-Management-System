<%-- 
    Document   : Home.jsp
    Created on : Nov 19, 2016, 3:38:10 PM
    Author     : samsung
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DI.db.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client</title>
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
        <form method="post" action="AddClient.do">
            <input type="submit" value="Add Client">
        </form>
        </br>
        <form method="post" action="ClientDue.jsp">
            <input type="submit" value="Due Status">
        </form>
        </br>
        <form method="post" action="DeleteClient.jsp">
            <input type="submit" value="Delete Client">
        </form>
        </br>
        <form method="post" action="ViewAllClient.do">
            <input type="submit" value="View All">
        </form>
    </body>
</html>