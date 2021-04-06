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
        <title>Medicine</title>
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
        
        <h1>Edit a Medicine</h1>
        <form method="post" action="EditMedicineInfo.do">
            Medicine Name<input type="text" name="medicineName" />
            
        </br>

            Retailed Price<input type="text" name="retailedPrice" />
        </br>
            <input type="submit" value="Update Medicine Info" />
        </form>
        </br> 
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
        
    </body>
</html>