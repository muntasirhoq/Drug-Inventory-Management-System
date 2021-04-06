<%-- 
    Document   : Purchase
    Created on : Dec 17, 2016, 5:58:50 PM
    Author     : Sifat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase</title>
    </head>
    <body>
        <h1>Add a Item!</h1>
        <form method="post" action="Purchase.do">
            Batch No <input type="text" name="batchNO" /> <br/>
            Medicine ID <input type="text" name="medicineID" /><br>
            Quantity <input type="text" name="quantity" /> <br/>
            <input type="submit" value="Add" />
        </form>
        </br>
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
