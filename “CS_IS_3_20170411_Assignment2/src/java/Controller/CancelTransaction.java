package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.bankAccountDao;
import Dao.bankTransactionDao;
import Model.BankAccount;
import Model.BankTransaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moaaz Hasan
 */
@WebServlet(urlPatterns = {"/CancelTransaction"})
public class CancelTransaction extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            bankTransactionDao BTDao = new bankTransactionDao();
            bankAccountDao BADao = new bankAccountDao();
            BankTransaction BT;
            BankAccount BAFrom;
            BankAccount BATo;
            int temp;
            String id = request.getParameter("IdTrans");
            System.out.println("id :" + id);
            int IdTrans = Integer.parseInt(id);
            System.out.println("IdTrans :" + IdTrans);
//            System.out.println(IdTrans);
            
            
            
            BT = BTDao.getTransaction(IdTrans);

            System.out.println(BT);

            BAFrom = BADao.SelectUserAccount(BT.getFromAccount());
            BATo = BADao.SelectUserAccount(BT.getToAccount());
            
            temp =  BATo.getCurrentBalance() - BT.getAmount();
            BADao.UpdateAmount(BATo.getBankAccountId() , temp);
            
            temp = BAFrom.getCurrentBalance() + BT.getAmount();
            BADao.UpdateAmount(BAFrom.getBankAccountId() , temp);
            
            BTDao.CancelTransaction(IdTrans);
            String message = "Successful Cancellation Transaction";
            request.getSession().setAttribute("message", message);
            response.sendRedirect("Transaction.jsp");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CancelTransaction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CancelTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CancelTransaction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CancelTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
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
