package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Dao.bankAccountDao;
import Dao.bankTransactionDao;
import Dao.customerDao;
import Model.BankAccount;
import Model.Customer;
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
@WebServlet(urlPatterns = {"/AddTransaction"})
public class AddTransaction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            bankTransactionDao BTDao = new bankTransactionDao();
            bankAccountDao BADao = new bankAccountDao();
            String message = "";
            BankAccount BAFrom;
            BankAccount BATo;
            int temp;

            int Amount = Integer.parseInt(request.getParameter("amount"));
            int from = Integer.parseInt(request.getParameter("from"));
            int to = Integer.parseInt(request.getParameter("to"));

            BAFrom = BADao.SelectUserAccount(from);
            BATo = BADao.SelectUserAccount(to);
            System.out.println("BAFrom ---> " + BAFrom);
            System.out.println("BATo ---> " + BATo);

            if (BAFrom.getCurrentBalance() >= Amount) {
                
                
                BTDao.AddTransaction(Amount, from, to);

                temp = BAFrom.getCurrentBalance() - Amount;
                int res2 = BADao.UpdateAmount(BAFrom.getBankAccountId(), temp);

                temp = BATo.getCurrentBalance() + Amount;
                int res = BADao.UpdateAmount(BATo.getBankAccountId(), temp);

                System.out.println(res + " , for from --> " + res2);
                 message = "Successful Transaction";

            } else {
                 message = "Your Amount less than Amount you want to transaction !!";
            }

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
            Logger.getLogger(AddTransaction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddTransaction.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddTransaction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddTransaction.class.getName()).log(Level.SEVERE, null, ex);
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
