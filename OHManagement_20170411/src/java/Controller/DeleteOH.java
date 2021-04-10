/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.office_hoursDao;
import Dao.reservationsDao;
import Model.office_hours;
import Model.reservation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moaaz Hasan
 */
@WebServlet(name = "DeleteOH", urlPatterns = {"/DeleteOH"})
public class DeleteOH extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int office_hoursDeleteID = Integer.parseInt(request.getParameter("office_hoursDeleteID"));
            
            processes pro = new processes();
            office_hoursDao OHDao = new office_hoursDao();
            List<office_hours> office_hoursList = new ArrayList();
            office_hoursList = OHDao.getAlloffice_hours();
            office_hours OH = new office_hours();
            OH = pro.getOHById(office_hoursList, office_hoursDeleteID);
            
            System.out.println("OH-----> " + OH);
            System.out.println("office_hoursDeleteID-----> " + office_hoursDeleteID);
            
            
            if(OH.isReserved() == 0){
                System.out.println("Inside IF */*/*/*/*/*/ Delete OH");
                OHDao = new office_hoursDao();
                OHDao.delete_office_hours(office_hoursDeleteID);
            }else{
                System.out.println("Inside ELSE IF */*/*/*/*/*/ Delete OH");
                reservation R = new reservation();
                List<reservation> reservationList = new ArrayList();
                reservationsDao RDao = new reservationsDao();
                reservationList = RDao.getReservationByOH_Id(office_hoursDeleteID);
                R = reservationList.get(0);
                RDao = new reservationsDao();
                RDao.deleteReservation(R.getReservitionId());
                
                OHDao = new office_hoursDao();
                OHDao.delete_office_hours(office_hoursDeleteID);
            }
            
            out.println("Successful delete office hours!");
            
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
