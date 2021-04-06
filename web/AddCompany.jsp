<%-- 
    Document   : AddWorker
    Created on : Dec 14, 2016, 2:46:22 PM
    Author     : Sifat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Company</title>
    </head>
    <body>
        <h1>Add a new Company!</h1>
        <form method="post" action="AddCompany.do">
            Company Name <input type="text" name="companyname" /><br>
            Address <input type="text" name="address" /> <br/>
            Country <input type="text" name="country" /> <br/>
            Email <input type="text" name="email" /> <br/>
            Phone Number <input type="text" name="phoneno" /> <br/>
            <input type="submit" value="Add" />
        </form>
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
