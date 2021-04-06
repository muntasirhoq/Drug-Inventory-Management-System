<%-- 
    Document   : ClientDelete
    Created on : Dec 19, 2016, 7:38:53 PM
    Author     : Sifat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1>Search a Medicine</h1>
        <form method="post" action="DeleteClientByName.do">
            Client Name<input type="text" name="clientName" /><input type="submit" value="Delete" />
        </form>
        </br> 
        <form method="post" action="DeleteClientById.do">
            Client ID <input type="text" name="clientID" /> <input type="submit" value="Delete" />
        </form>
        </br>
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
