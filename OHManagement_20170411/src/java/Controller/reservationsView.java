/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.reservationsDao;
import Dao.userDao;
import Model.reservation;
import Model.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "reservationsView", urlPatterns = {"/reservationsView"})
public class reservationsView extends HttpServlet {

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
            int OH_Id = Integer.parseInt(request.getParameter("OH_Id"));
            int userActiveId = Integer.parseInt(request.getParameter("userActiveId"));
            List<reservation> reservationList = new ArrayList();
            reservationsDao RDao = new reservationsDao();
            
            reservationList = RDao.getReservationByOH_Id(OH_Id);
            System.out.println("reservationList ---> "+ reservationList);
            System.out.println("userActiveId ---> "+ userActiveId);
            System.out.println("OH_Id ---> "+ OH_Id);
            processes pro = new processes();
            user u = new user();
            List<user> userList = new ArrayList();
            userDao uDao = new userDao();
            userList = uDao.getAllUsers();
            System.out.println("userList ---> "+ userList);
            u = pro.getUserById(userList, reservationList.get(0).getUserIdFrom());
            System.out.println("u ---> "+ u);
            System.out.println("reservationList.get(0).getUserIdFrom() ---> "+ reservationList.get(0).getUserIdFrom());
            out.print(" <h5 class=\"align-content-center\" > This appointment was booked by <strong style=\"color: blue\"> " +  u.getUsername() + " </strong style=\"color: blue\"> on <strong> " + reservationList.get(0).getDate() + " </strong>  </h5> ");
            
            
            
            
            
            
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
            Logger.getLogger(reservationsView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reservationsView.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(reservationsView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reservationsView.class.getName()).log(Level.SEVERE, null, ex);
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
