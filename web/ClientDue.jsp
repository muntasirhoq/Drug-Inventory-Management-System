<%-- 
    Document   : Home.jsp
    Created on : Nov 19, 2016, 3:38:10 PM
    Author     : samsung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Due</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("username");
            if(username==null)
            {
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
            }
        %>
        
        <h1>Company Due</h1>
        <form method="post" action="ClientDue.do">
            Client ID<input type="text" name="clientID" /><input type="submit" value="Check Due" />
        </form>
        </br> 
        
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
        
    </body>
</html>
