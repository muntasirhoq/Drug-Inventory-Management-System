<%-- 
    Document   : AddMedicine
    Created on : Dec 18, 2016, 3:32:52 AM
    Author     : Sifat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Medicine</title>
    </head>
    <body>
        <h1>Add a Medicine</h1>
        <form method="post" action="AddMedicine.do">
            Medicine Name <input type="text" name="medicineName" /><br>
            Generic Name <input type="text" name="genericName" /><br>
            Company ID <input type="text" name="companyID" /> <br/>
            Retailed Price <input type="text" name="retailedPrice" /> <br/>
            Status <input type="text" name="status" /> <br/>
            <input type="submit" value="Add" />
        </form>
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
