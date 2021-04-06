<%-- 
    Document   : ShipmentAddItem
    Created on : Dec 18, 2016, 11:12:16 PM
    Author     : Sifat
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DI.db.DataAccess"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1> Current Curt</h1>
        <form method="post" action="ShipmentAddItem.do">
        <%
            String invoiceNO=(String)session.getAttribute("currval");
            DataAccess db = new DataAccess();
            List <String> inventory = new ArrayList<String>();
            inventory = db.getShipmentCart(invoiceNO);
            int len = inventory.size();
            for(int i = 0; i < len; i++){
                out.println(inventory.get(i));
            }
         %>
        </form>
        <h1>Add another new Item</h1>
        <form method="post" action="ShipmentAddItem.do">
            Medicine ID <input type="text" name="medicineID" /><br>
            Batch No <input type="text" name="batchNO" /> <br/>
            Quantity <input type="text" name="quantity" /> <br/>
            Purchased Price <input type="text" name="purchasedPrice" /> <br/>
            Expiry Date <input type="text" name="expiryDate" /> <br/>
            <input type="submit" value="Add" />
        </form>
        </br>
        <h1>Create Shipment Invoice</h1>
        <form method="post" action="ShipmentInvoice.do">
            <input type="submit" value="Create Invoice">
        </form>    
    </body>
</html>
