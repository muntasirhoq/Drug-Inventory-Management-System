<%-- 
    Document   : Shipment
    Created on : Dec 14, 2016, 3:19:19 PM
    Author     : Sifat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipment</title>
    </head>
    <body>
        <h1>Add a new Item</h1>
        <form method="post" action="Shipment.do">
            Medicine ID <input type="text" name="medicineID" /><br>
            Batch No <input type="text" name="batchNO" /> <br/>
            Quantity <input type="text" name="quantity" /> <br/>
            Purchased Price <input type="text" name="purchasedPrice" /> <br/>
            Expiry Date <input type="text" name="expiryDate" /> <br/>
            <input type="submit" value="Add" />
        </form>
        </br>
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
