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
        <title>Client</title>
    </head>
    <body>
        <h1>Add a new Client!</h1>
        <form method="post" action="AddClient.do">
            First Name <input type="text" name="firstName" /><br>
            Last Name <input type="text" name="lastName" /> <br/>
            Address <input type="text" name="address" /> <br/>
            Phone Number <input type="text" name="phoneno" /> <br/>
            <input type="submit" value="Add" />
        </form>
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
