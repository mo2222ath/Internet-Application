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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moaaz Hasan
 */
@WebServlet(name = "EditOH", urlPatterns = {"/EditOH"})
public class EditOH extends HttpServlet {

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
            String OHDateEdit =  request.getParameter("OHDateEdit");
            String OHTimeFromEdit = request.getParameter("OHTimeFromEdit");
            String OHTimeToEdit = request.getParameter("OHTimeToEdit");
            int OHID = Integer.parseInt(request.getParameter("OHID"));
            int StaffIDEdit = Integer.parseInt(request.getParameter("StaffIDEdit"));

            System.out.println("OHDateEdit --> " + OHDateEdit);
            System.out.println("OHTimeFromEdit --> " + OHTimeFromEdit);
            System.out.println("OHTimeToEdit --> " + OHTimeToEdit);
            System.out.println("OHID --> " + OHID);
            System.out.println("StaffIDEdit --> " + StaffIDEdit);
            
            
            office_hours OH = new office_hours(OHID , StaffIDEdit , OHDateEdit ,OHTimeFromEdit,OHTimeToEdit );
            office_hoursDao OHDao = new office_hoursDao();
            System.out.println("OH obbbbjjjjjeeeccccttt --> " + OH);

            OHDao.update_office_hours(OH);
            
            out.print("Successful Edit Office Hours !");
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
