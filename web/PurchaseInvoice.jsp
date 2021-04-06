<%-- 
    Document   : PurchaseInvoice
    Created on : Dec 18, 2016, 3:09:03 PM
    Author     : Sifat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase Invoice</title>
    </head>
    <body>
        <h1>Purchase Invoice</h1>
        <form method="post" action="PurchaseInvoice.do">
            Client ID <input type="text" name="clientID" /> <br/>
            Paid Amount <input type="text" name="paidAmount" /> <br/>
            Discount <input type="text" name="discount" /> <br/>
            Worker ID <input type="text" name="workerID" /> <br/>
            <input type="submit" value="Add" />
        </form>
        </br>
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>

