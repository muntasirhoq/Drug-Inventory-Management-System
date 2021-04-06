<%-- 
    Document   : ShipmentInvoice
    Created on : Dec 18, 2016, 11:12:39 PM
    Author     : Sifat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <form method="post" action="ShipmentInvoice.do">
            <h1>Create Invoice</h1>
            Company ID <input type="text" name="companyID" /> <br/>
            Paid Amount <input type="text" name="paidAmount" /> <br/>
            Worker ID <input type="text" name="workerID" /> <br/>
            <input type="submit" value="Add" />
        </form>
        </br>
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
</html>
