<%-- 
    Document   : PurchaseAddItem
    Created on : Dec 18, 2016, 3:08:42 PM
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
        <title>Purchase</title>
    </head>
    <body>
        <h1> Current Curt</h1>
        <form method="post" action="ShipmentAddItem.do">
        <%
            String invoiceNO=(String)session.getAttribute("currval");
            DataAccess db = new DataAccess();
            List <String> inventory = new ArrayList<String>();
            inventory = db.getPurchaseCart(invoiceNO);
            int len = inventory.size();
            for(int i = 0; i < len; i++){
                out.println(inventory.get(i));
            }
         %>
        <h1>Add another new Item</h1>
        <form method="post" action="PurchaseAddItem.do">
            Batch No <input type="text" name="batchNO" /> <br/>
            Medicine ID <input type="text" name="medicineID" /><br>
            Quantity <input type="text" name="quantity" /> <br/>
            <input type="submit" value="Add" />
        </form>
        </br>
        <h1>Create Purchase Invoice</h1>
        <form method="post" action="PurchaseInvoice.do">
            <input type="submit" value="Create Invoice">
        </form>    
    </body>
</html>
