/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.subjectDao;
import Dao.userDao;
import Model.user;
import email.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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

//            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
//            System.out.println("gRecaptchaResponse ------> " + gRecaptchaResponse);
//            boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
//            System.out.println("verify ------> " + verify);

//            if (verify) {

                user u = null;
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String type = request.getParameter("type");
                String subjName = request.getParameter("subjId");
                int subid;

                System.out.println("username -- >" + username);
                System.out.println("email -- >" + email);
                System.out.println("type -- >" + type);
                System.out.println("subjId -- >" + subjName);

                final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                SecureRandom random = new SecureRandom();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    int randomIndex = random.nextInt(chars.length());
                    sb.append(chars.charAt(randomIndex));
                }
                String password = sb.toString();

                boolean isSend;
                String to = email;
                String msg = "Hi, " + username + "\nUse this password to login to our website: " + password + "\nThanks.";
                String subjectMsg = "Password for login to the offiec hours management website!";

                userDao uDao = new userDao();
                boolean c1 = uDao.emailisNotExist(email);
                System.out.println("email c :" + c1);

                uDao = new userDao();
                boolean c2 = uDao.usernameIsNotExist(username);
                System.out.println("username c :" + c2);

                if (type.equals("true")) {
                    u = new user(username, email, password, "student");
                } else {
                    subjectDao SDao = new subjectDao();
                    subid = SDao.getSubjectId(subjName);
                    u = new user(username, email, password, "staff", subid);

                }

                if (c1 && c2) {
                    SendMail.send(to, subjectMsg, msg);
                    uDao = new userDao();
                    uDao.addUser(u);
                    out.print("Successful register , the password is sent to an email! ");
                } else {
                    out.print("Faild register , be sure of info and try again! ");
                }
//            }else{
//                out.print("Faild register , be sure of Verify ReCaptcha! ");
//            }
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
