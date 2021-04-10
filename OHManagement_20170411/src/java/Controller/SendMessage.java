/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.messageDao;
import Dao.notificationDao;
import Dao.subjectDao;
import Dao.userDao;
import Model.message;
import Model.notification;
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
@WebServlet(name = "SendMessage", urlPatterns = {"/SendMessage"})
public class SendMessage extends HttpServlet {

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
            String team = request.getParameter("team");
            String contactMessage = request.getParameter("contactMessage");
            int UserID = Integer.parseInt(request.getParameter("UserID"));
            
            processes pro = new processes();
            List<user> listUsers = new ArrayList();
            userDao uDao = new userDao();
            listUsers = uDao.getAllUsers();
            user getFrom = pro.getUserById(listUsers, UserID);
            messageDao MDao;

            if (team.equals("true")) {
                String subjectValue = request.getParameter("subjectValue");
                subjectDao SDao = new subjectDao();
                int idSubj = SDao.getSubjectId(subjectValue);
                List<user> listUserResult = new ArrayList();

                listUserResult = pro.getUsersBySubjectId(listUsers, idSubj);
                Date date = new Date();
                if (listUserResult.isEmpty()) {
                    out.println("There is no staff in this subject!!");
                } else {
                    
                    for (int i = 0; i < listUserResult.size(); i++) {
                        user getTo = listUserResult.get(i);
                        message msg = new message(UserID, getTo.getUserId(), contactMessage, date);
                        MDao = new messageDao();
                        MDao.addMessage(msg);
                        
                        
                        String NotifyMsg = "The message was sent from " +  getFrom.getUsername() +  " to "  + getTo.getUsername() ;
                        notification N = new notification(getFrom.getUserId() , getTo.getUserId() , NotifyMsg ,date);
                        notificationDao NDao = new notificationDao();
                        NDao.addNotification(N);
                        
                        SendMail.send(getTo.getEmail(), "New Massege!", NotifyMsg);
                        
                        out.print("Successful Send Message!");
                        
                    }
                }
            } else {
                String emailToSend = request.getParameter("emailToSend");
                uDao = new userDao();
                boolean check = uDao.emailisNotExist(emailToSend);
                if (check) {
                    out.println("There is not uesr in this Email!!");
                } else {
                    Date date = new Date();
                    user getTo = pro.getUsersByEmail(listUsers, emailToSend);
                    message msg = new message(UserID, getTo.getUserId(), contactMessage, date);
                    MDao = new messageDao();
                    MDao.addMessage(msg);
                    
                    String NotifyMsg = "The message was sent from " +  getFrom.getUsername() +  " to "  + getTo.getUsername() ;
                    notification N = new notification(getFrom.getUserId() , getTo.getUserId() , NotifyMsg ,date);
                    notificationDao NDao = new notificationDao();
                    NDao.addNotification(N);

                    SendMail.send(getTo.getEmail(), "New Massege!", NotifyMsg);
                    
                    
                    out.print("Successful Send Message!");
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
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
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
