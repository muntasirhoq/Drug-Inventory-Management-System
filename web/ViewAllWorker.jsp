<%-- 
    Document   : ViewAllWorker
    Created on : Dec 18, 2016, 11:53:21 AM
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
        <form method="post" action="ViewAllWorker.do">
        <%
            DataAccess db = new DataAccess();
            List <String> worker = new ArrayList<String>();
            worker = db.getWorker();
            int len = worker.size();
            for(int i = 0; i < len; i++){
                out.println(worker.get(i));
            }
            %>
        </form>
        </br> 
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
