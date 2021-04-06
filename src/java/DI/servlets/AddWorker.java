/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DI.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DI.db.DataAccess;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author samsung
 */

@WebServlet(name = "AddWorker", urlPatterns = {"/AddWorker.do"})
public class AddWorker extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String hiredate = request.getParameter("hiredate");
        String salary = request.getParameter("salary");
        String address = request.getParameter("address");
        String phoneno = request.getParameter("phoneno");
        int countMain=1;
        
        /*String reguser="[A-za-z]+";
        String regsalary="[0-9]+";
        Pattern patternName = Pattern.compile(reguser);
        Pattern patternSalary = Pattern.compile(regsalary);*/
        
        DataAccess db = new DataAccess();
        if(countMain==1)
        {
            int count=0;
            /*Matcher first = patternName.matcher(firstName);
            Matcher last = patternName.matcher(lastName);
            Matcher sal = patternSalary.matcher(salary);
            Matcher phone = patternSalary.matcher(phoneno);
            if(first.matches()==true && last.matches()==true && sal.matches()==true && phone.matches()==true )*/
                count = db.AddWorker(firstName, lastName, hiredate, salary, address, phoneno);
            if(count==1)
            {
                RequestDispatcher rd = request.getRequestDispatcher("Worker.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("AddWorker.jsp");
                rd.forward(request, response); 
            }
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("Worker.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
