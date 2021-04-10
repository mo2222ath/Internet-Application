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
import Model.subject;
import Model.user;
import email.SendMail;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Moaaz Hasan
 */
public class processes {
    
    public user getUserById(List<user> userList , int id){
        user u = new user();
        
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getUserId() == id ){
                u = userList.get(i);
                break;
            }
        }
        return u;
    }
    
    public user getUserByUsername(List<user> userList , String username){
        user u = new user();
        
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getUsername().equals(username)){
                u = userList.get(i);
                return u;
            }
        }
        return u;
    }
    
    public subject getSubjectBySubjId(List<subject> subjectList , int subjId){
        subject S = new subject();
        
        for (int i = 0; i < subjectList.size(); i++) {
            if(subjectList.get(i).getSubjectId() == subjId){
                S = subjectList.get(i);
                return S;
            }
        }
        return S;
    }
    
    public subject getSubjectBySubjName(List<subject> subjectList , String subjName){
        subject S = new subject();
        
        for (int i = 0; i < subjectList.size(); i++) {
            if(subjectList.get(i).getName().equals(subjName)){
                S = subjectList.get(i);
                return S;
            }
        }
        return S;
    }
    
    
    public office_hours getOHById(List<office_hours> OHList , int id){
        office_hours OH = new office_hours();
        
        for (int i = 0; i < OHList.size(); i++) {
            if(OHList.get(i).getOffice_hoursId() == id ){
                OH = OHList.get(i);
                break;
            }
        }
        return OH;
    }
    
    public List<user> getUsersBySubjectId(List<user> userList , int id){
        List<user> listUserResult = new ArrayList();
        
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getSubjectId() == id ){
                listUserResult.add(userList.get(i));
            }
        }
        return listUserResult;
    }
    
    public user getUsersByEmail(List<user> userList , String email){
        user u = new user();
        
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getEmail().equals(email)){
                return u = userList.get(i);
            }
        }
        return u;
    }
    
    
    public reservation getReservationByOHId(List<reservation> reservationList , int id){
        reservation R = new reservation();
        
        for (int i = 0; i < reservationList.size(); i++) {
            if(reservationList.get(i).getOffice_hoursId() == id ){
                R = reservationList.get(i);
                break;
            }
        }
        return R;
    }
    
    
    public void makeNotifyOnDay() throws ClassNotFoundException, SQLException{
        
        List<office_hours> office_hoursList = new ArrayList();
        office_hoursDao OHDao = new office_hoursDao();
        office_hoursList = OHDao.getAlloffice_hours();

        notification N1 , N2;
        notificationDao NDao;
        reservation R;
        List<reservation> reservationList = new ArrayList();
        reservationsDao RDao ;
        List<user> listUsers = new ArrayList();
        userDao uDao = new userDao();
        listUsers = uDao.getAllUsers();

        for (int i = 0; i < office_hoursList.size(); i++) {
 
            R = new reservation();
            Date date = new Date();
            if(office_hoursList.get(i).getRememberMetting() == 0 && office_hoursList.get(i).isReserved() == 1){
                RDao = new reservationsDao();
                reservationList = RDao.getReservationByOH_Id(office_hoursList.get(i).getOffice_hoursId());
                R = reservationList.get(0);
                if(R.getDate().getDate() == date.getDate() ){
                    N1 = new notification(0,R.getUserIdFrom(),"You have a Meeting Today!" , date);
                    NDao = new notificationDao();
                    NDao.addNotification(N1);
                    N2 = new notification(0,R.getUserIdTo(),"You have a Meeting Today!" , date);
                    NDao = new notificationDao();
                    NDao.addNotification(N2);

                    user getFrom = getUserById(listUsers,R.getUserIdFrom());
                    user getTo = getUserById(listUsers,R.getUserIdTo());
                    
                    SendMail.send(getFrom.getEmail(), "New Massege!", "You have a Meeting Today!");
                    SendMail.send(getTo.getEmail(), "New Massege!", "You have a Meeting Today!");
                }
            }      
        }    
    }
    
    
    
     
    
    
    
}
