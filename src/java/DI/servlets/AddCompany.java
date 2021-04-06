/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DI.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DI.db.DataAccess;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author samsung
 */

@WebServlet(name = "AddCompany", urlPatterns = {"/AddCompany.do"})
public class AddCompany extends HttpServlet {

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
       
        String companyname = request.getParameter("companyname");
        String address = request.getParameter("address");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String due = "0";
        String phoneno = request.getParameter("phoneno");
        int countMain=1;
        
        DataAccess db = new DataAccess();
        if(countMain==1)
        {
            int count = db.AddCompany(companyname, address, country, email,due, phoneno);
            if(count==1)
            {
                RequestDispatcher rd = request.getRequestDispatcher("Company.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("AddCompany.jsp");
                rd.forward(request, response); 
            }
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("AddCompany.jsp");
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
