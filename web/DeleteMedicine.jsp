<%-- 
    Document   : DeleteMedicine
    Created on : Dec 19, 2016, 11:46:11 PM
    Author     : Sifat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1>Search a Medicine</h1>
        <form method="post" action="DeleteMedicineByName.do">
            Medicine Name<input type="text" name="medicineName" /><input type="submit" value="Delete" />
        </form>
        </br> 
        <form method="post" action="DeleteMedicineById.do">
            Medicine ID <input type="text" name="medicineID" /> <input type="submit" value="Delete" />
        </form>
        </br>
        <form method="post" action="DeleteMedicineByGenericName.do">
            Generic Name <input type="text" name="genericName" /> <input type="submit" value="Delete" />
        </form>
        </br>
        <form method="post" action="DeleteMedicineByCompany.do">
            Company Name <input type="text" name="companyName" /> <input type="submit" value="Delete" />
        </form>
        </br>
        <form method="post" action="Home.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
