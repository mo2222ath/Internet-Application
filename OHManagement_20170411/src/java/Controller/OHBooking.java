/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.notificationDao;
import Dao.office_hoursDao;
import Dao.reservationsDao;
import Dao.userDao;
import Model.notification;
import Model.office_hours;
import Model.reservation;
import Model.user;
import email.SendMail;
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
@WebServlet(name = "OHBooking", urlPatterns = {"/OHBooking"})
public class OHBooking extends HttpServlet {

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
            int office_hoursIDBOOKING = Integer.parseInt(request.getParameter("office_hoursIDBOOKING"));
            int StudID = Integer.parseInt(request.getParameter("StudID"));

            processes pro = new processes();
            office_hoursDao OHDao = new office_hoursDao();
            List<office_hours> office_hoursList = new ArrayList();
            office_hoursList = OHDao.getAlloffice_hours();
            office_hours OH = new office_hours();
            OH = pro.getOHById(office_hoursList, office_hoursIDBOOKING);
            OH.setReserved(1);
            OHDao = new office_hoursDao();
            

            reservationsDao RDao = new reservationsDao();
            Date date = new Date();
            reservation res = new reservation(date, OH.getOffice_hoursId() ,StudID, OH.getUserId());
            RDao.addReservation(res);
            
            OHDao.update_office_hours(OH);
            
            List<user> listUsers = new ArrayList();
            userDao uDao = new userDao();
            listUsers = uDao.getAllUsers();
            user getFrom = pro.getUserById(listUsers, StudID);
            user getTo = pro.getUserById(listUsers, OH.getUserId());
                    
            
            String NotifyMsg = "The Reservation was added from " +  getFrom.getUsername() +  " to "  + getTo.getUsername() ;
            notification N = new notification(getFrom.getUserId() , getTo.getUserId() , NotifyMsg ,date);
            notificationDao NDao = new notificationDao();
            NDao.addNotification(N);

            SendMail.send(getTo.getEmail(), "New Massege!", NotifyMsg);
            
            
            out.println("successful appointment Booking!");

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
            Logger.getLogger(OHBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OHBooking.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OHBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OHBooking.class.getName()).log(Level.SEVERE, null, ex);
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
