/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DI.servlets;

import DI.db.DataAccess;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sifat
 */
@WebServlet(name = "Purchase", urlPatterns = {"/Purchase.do"})
public class Purchase extends HttpServlet {

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
        //String invoiceNo = request.getParameter("invoiceNO");
        String medicineID  = request.getParameter("medicineID");
        String batchNo  = request.getParameter("batchNO");
        String quantity = request.getParameter("quantity");
        //String purchaseDate = request.getParameter("purchaseDate");
        /*String clientID = request.getParameter("clientID");
        String paidAmount  = request.getParameter("paidAmount");
        String discount = request.getParameter("discount");
        String workerID = request.getParameter("workerID");
        count = db.AddInvoice(clientID,paidAmount,discount,workerID);*/
            
        int countMain=1;
        
        DataAccess db = new DataAccess();
        if(countMain==1)
        {
            int count = db.AddItem(batchNo,medicineID, quantity);
            if(count==1)
            {
                String currval=db.CurSeq();
                HttpSession session = request.getSession();
                session.setAttribute("currval",currval);
                RequestDispatcher rd = request.getRequestDispatcher("PurchaseAddItem.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("Purchase.jsp");
                rd.forward(request, response); 
            }
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("Purchase.jsp");
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

