<%-- 
    Document   : ViewClient
    Created on : Dec 15, 2016, 11:51:51 PM
    Author     : Sifat
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DI.db.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Client</title>
    </head>
    <body>
        <form method="post" action="ViewAllClient.do">
        <%
            DataAccess db = new DataAccess();
            List <String> client = new ArrayList<String>();
            client = db.getClient();
            int len = client.size();
            for(int i = 0; i < len; i++){
                out.println(client.get(i));
            }
            %>
        </form>
        </br> 
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
