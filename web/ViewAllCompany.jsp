<%-- 
    Document   : ViewAllCompany
    Created on : Dec 19, 2016, 12:05:40 PM
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
        <title>View Worker</title>
    </head>
    <body>
        <form method="post" action="ViewAllCompany.do">
        <%
            DataAccess db = new DataAccess();
            List <String> company = new ArrayList<String>();
            company = db.getCompany();
            int len = company.size();
            for(int i = 0; i < len; i++){
                out.println(company.get(i));
            }
            %>
        </form>
        </br> 
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>