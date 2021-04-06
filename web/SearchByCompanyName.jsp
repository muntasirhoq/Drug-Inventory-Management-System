<%-- 
    Document   : ViewAllWorker
    Created on : Dec 18, 2016, 11:53:21 AM
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
        <form method="post" action="SearchByMedicineName.do">
        <%
            //session = request.getSession();
            String companyName=(String)session.getAttribute("companyName");
            //System.out.println("medicine="+medicineName);
            DataAccess db = new DataAccess();
            List <String> medicine = new ArrayList<String>();
            medicine = db.getSearchByCompanyName(companyName);
            int len = medicine.size();
            System.out.println("Fuck"+len);
            for(int i = 0; i < len; i++){
                out.println(medicine.get(i));
            }
            %>
        </form>
    </body>
</html>
