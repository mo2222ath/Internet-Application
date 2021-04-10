package email;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moaaz Hasan
 */
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {

    public static boolean send(String to, String sub, String msg) {
        //create an instance of Properties Class   
        Properties props = new Properties();
        final String user = "mo2222ath@gmail.com";
        final String pass = "71313313";

        /*  Specifies the IP address of your default mail server
     	      for e.g if you are using gmail server as an email sever
            you will pass smtp.gmail.com as value of mail.smtp host. 
            As shown here in the code. 
            Change accordingly, if your email id is not a gmail id
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        // below mentioned mail.smtp.port is optional 
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
         */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {

            /*  Create an instance of MimeMessage, 
     	          it accept MIME types and headers 
             */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
