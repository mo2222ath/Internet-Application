/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.office_hoursDao;
import Model.office_hours;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(name = "AddOH", urlPatterns = {"/AddOH"})
public class AddOH extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String OHDateAdd =  request.getParameter("OHDateAdd");
            String OHTimeFromAdd = request.getParameter("OHTimeFromAdd");
            String OHTimeToAdd = request.getParameter("OHTimeToAdd");
            int StaffID = Integer.parseInt(request.getParameter("StaffID"));
            

            System.out.println("OHDateAdd --> " + OHDateAdd);
            System.out.println("OHTimeFromAdd --> " + OHTimeFromAdd);
            System.out.println("OHTimeToAdd --> " + OHTimeToAdd);
            System.out.println("StaffID --> " + StaffID);
            
            
            office_hours OH = new office_hours(OHDateAdd ,StaffID,OHTimeFromAdd,OHTimeToAdd);
            office_hoursDao OHDao = new office_hoursDao();
            System.out.println("OH obbbbjjjjjeeeccccttt --> " + OH);

            OHDao.Add_office_hours(OH);
            
            
//            response.sendRedirect("staffPage.jsp");
            
            out.print("Successful Added Office Hours!");
            
            
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
        } catch (ParseException ex) {
            Logger.getLogger(AddOH.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(AddOH.class.getName()).log(Level.SEVERE, null, ex);
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
