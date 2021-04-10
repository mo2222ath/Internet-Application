/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.subjectDao;
import Dao.userDao;
import Model.subject;
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

/**
 *
 * @author Moaaz Hasan
 */
@WebServlet(name = "saveEditProfile", urlPatterns = {"/saveEditProfile"})
public class saveEditProfile extends HttpServlet {

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

            String Dname = request.getParameter("Dname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String subj = request.getParameter("subj");
            int userId = Integer.parseInt(request.getParameter("userId"));
            int subjId = -1;

            processes pro = new processes();
            
            user uTemp = new user();
            userDao uDao = new userDao();
            List<user> userList = new ArrayList();
            userList = uDao.getAllUsers();
            uTemp = pro.getUserById(userList, userId);
                       
            if(uTemp.getType().equals("staff")){
                subject S = new subject();
                List<subject> subjectList = new ArrayList();
                subjectDao SDao = new subjectDao();
                subjectList = SDao.getAllSubject();
                S = pro.getSubjectBySubjName(subjectList, subj);
                subjId = S.getSubjectId();
            }
            
            if(password.equals("")){
                password = uTemp.getPassword();
            }
            
            uTemp.setDisplayName(Dname);
            uTemp.setEmail(email);
            uTemp.setPassword(password);
            uTemp.setSubjectId(subjId);
            
            uDao = new userDao();
            uDao.updateUser(uTemp);
            out.print("Successful edit Profile!");
             
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
            Logger.getLogger(saveEditProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(saveEditProfile.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(saveEditProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(saveEditProfile.class.getName()).log(Level.SEVERE, null, ex);
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
