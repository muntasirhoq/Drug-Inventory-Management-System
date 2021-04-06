<%-- 
    Document   : ViewInventory
    Created on : Dec 20, 2016, 12:54:35 AM
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
        <title>View Generic</title>
    </head>
    <body>
        <form method="post" action="SearchByMedicineName.do">
        <%
            DataAccess db = new DataAccess();
            List <String> inventory = new ArrayList<String>();
            inventory = db.getInventory();
            int len = inventory.size();
            for(int i = 0; i < len; i++){
                out.println(inventory.get(i));
            }
            %>
        </form>
    </body>
</html>
