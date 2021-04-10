/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.userDao;
import Model.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Moaaz Hasan
 */
@WebServlet(name = "validateLogin", urlPatterns = {"/validateLogin"})
public class validateLogin extends HttpServlet {

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
            List<user> userList = new ArrayList();
            user u = new user();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
//            System.out.println("email ----> " + email);
//            System.out.println("password ----> " + password);
            userDao uDao = new userDao();
            userList = uDao.checkLogin(email);
//            System.out.println("VVVVAAALLLDADDATTTEEEe");
            if(userList.isEmpty()){
//                out.print("Wrong login !\nTry Again");
                    response.sendRedirect("index.jsp");
            }else{
                u = userList.get(0);
//                System.out.println("before check password ----> " + password);
                if(u.getPassword().equals(password)){
                    System.out.println("After check password ----> " + password);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", u);
                    System.out.println("before check type ----> " + u.getType());
                    if(u.getType().equals("staff")){
                        System.out.println("after check type ----> " + u.getType());
                        response.sendRedirect("staffPage.jsp");
//                        out.print("staff");
                    }else{
                        System.out.println("after check type ----> " + u.getType());
                        response.sendRedirect("studentPage.jsp");
//                        out.print("student");
                    }
                }else{
                    response.sendRedirect("index.jsp");
//                    out.print("Wrong login !\nTry Again");
                }

            }
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
            Logger.getLogger(validateLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(validateLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(validateLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(validateLogin.class.getName()).log(Level.SEVERE, null, ex);
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
