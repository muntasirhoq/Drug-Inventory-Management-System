<%-- 
    Document   : ViewClientDue
    Created on : Dec 20, 2016, 9:58:19 AM
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
        <title>View Generic</title>
    </head>
    <body>
        <form method="post" action="ViewCompanyDue.jsp">
        <%
            //session = request.getSession();
            String clientID=(String)session.getAttribute("clientID");
            //System.out.println("medicine="+medicineName);
            DataAccess db = new DataAccess();
            List <String> medicine = new ArrayList<String>();
            medicine = db.getClientDue(clientID);
            int len = medicine.size();
            for(int i = 0; i < len; i++){
                out.println(medicine.get(i));
            }
            %>
        </form>
    </body>
</html>
