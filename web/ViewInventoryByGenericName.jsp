<%-- 
    Document   : ViewInventoryByGenericName
    Created on : Dec 20, 2016, 1:40:40 AM
    Author     : Sifat
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DI.db.DataAccess"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Medicine</title>
    </head>
    <body>
        <form method="post" action="ViewInventoryByGenericName.do">
        <%
            //session = request.getSession();
            String genericName=(String)session.getAttribute("genericName");
            //System.out.println("medicine="+medicineName);
            DataAccess db = new DataAccess();
            List <String> inventory = new ArrayList<String>();
            inventory = db.getInventoryByGenericName(genericName);
            int len = inventory.size();
            for(int i = 0; i < len; i++){
                out.println(inventory.get(i));
            }
            %>
        </form>
    </body>
</html>
