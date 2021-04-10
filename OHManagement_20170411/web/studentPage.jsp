<%-- 
    Document   : studentPage
    Created on : Jan 2, 2021, 7:29:52 PM
    Author     : Moaaz Hasan
--%>

<%@page import="Dao.reservationsDao"%>
<%@page import="Model.reservation"%>
<%@page import="Model.subject"%>
<%@page import="Dao.subjectDao"%>
<%@page import="Controller.processes"%>
<%@page import="java.util.Date"%>
<%@page import="Dao.messageDao"%>
<%@page import="Dao.userDao"%>
<%@page import="Model.message"%>
<%@page import="Model.notification"%>
<%@page import="Dao.notificationDao"%>
<%@page import="Dao.office_hoursDao"%>
<%@page import="Model.office_hours"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.user"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    user u = null;
    if (session.getAttribute("user") == null) {
        request.getRequestDispatcher("index.jsp").include(request, response);

    } else {
        u = (user) session.getAttribute("user");
%>



<html lang="en">


    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />

        <title>OH Management</title>

        <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" /> -->
        <link rel="stylesheet" href="css/all.min.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="slick/slick.css" />
        <link rel="stylesheet" href="slick/slick-theme.css" />
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/templatemo-dream-pulse.css" />
        <link rel="stylesheet" href="css/style.css">
    </head>



    <%        office_hoursDao OHDao = new office_hoursDao();
        List<office_hours> office_hoursList = new ArrayList();
        office_hoursList = OHDao.getAlloffice_hours();

        notificationDao NDao = new notificationDao();
        List<notification> notificationList = new ArrayList();
        notificationList = NDao.getnotification(u.getUserId());

        messageDao MDao = new messageDao();
        List<message> messageList = new ArrayList();
        messageList = MDao.getmessage(u.getUserId());

        userDao uDao = new userDao();
        List<user> userList = new ArrayList();
        userList = uDao.getAllUsers();

        subjectDao SDao = new subjectDao();
        List<subject> subjectList = new ArrayList();
        subjectList = SDao.getAllSubject();

        List<reservation> reservationList = new ArrayList();
        reservationsDao RDao = new reservationsDao();
        reservationList = RDao.getReservationByStudentID(u.getUserId());
        processes pro = new processes();

    %>

    <body>

        <main class="container-fluid">
            <div class="row">
                <nav id="tmSidebar" class="tm-bg-black-transparent tm-sidebar">

                    <a href="profile.jsp" style="color: white" class="btn-outline-secondary border signup-image-link align-self-md-end">Edit Profile</a>
                    <a href="index.jsp" style="color: white" class="btn-outline-secondary border signup-image-link align-self-md-end">logout</a>
                    <button class="navbar-toggler" type="button" aria-label="Toggle navigation"><i class="fas fa-bars"></i></button>
                    <div class="tm-sidebar-sticky ">
                        <div class="tm-brand-box">
                            <div class="tm-double-border-1">
                                <div class="tm-double-border-2">
                                    <h1 class="tm-brand text-uppercase">
                                        <%= u.getUsername()%>
                                    </h1>
                                </div>
                            </div>
                        </div>

                        <ul id="tmMainNav" class="nav flex-column text-uppercase text-right tm-main-nav">
                            <li class="nav-item">
                                <a href="#intro" class="nav-link active">
                                    <span class="d-inline-block mr-3">Intro</span>
                                    <span class="d-inline-block tm-white-rect"></span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#Reservations" class="nav-link">
                                    <span class="d-inline-block mr-3">Reservitions</span>
                                    <span class="d-inline-block tm-white-rect"></span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#OH" class="nav-link">
                                    <span class="d-inline-block mr-3">office Hours</span>
                                    <span class="d-inline-block tm-white-rect"></span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#notifications" class="nav-link">
                                    <span class="d-inline-block mr-3">Notifications</span>
                                    <span class="d-inline-block tm-white-rect"></span>
                                </a>
                            </li> 
                            <li class="nav-item">
                                <a href="#messages" class="nav-link">
                                    <span class="d-inline-block mr-3">Messages</span>
                                    <span class="d-inline-block tm-white-rect"></span>
                                </a>
                            </li>

                        </ul>

                    </div>
                </nav>

                <main role="main" class="ml-sm-auto col-12">
                    <div class="parallax-window" data-parallax="scroll" data-image-src="images/home_sec.jpg">
                        <div class="tm-section-wrap">

                            <section id="intro" class="tm-section">
                                <div class="tm-bg-black-transparent tm-intro">
                                    <h2 class="tm-section-title mb-5 text-uppercase tm-color-primary">Search for Staff member</h2>

                                    <!--Search By Username-->
                                    <form method="POST" class="Search_formClass" style="padding: 5px" id="Search_formSpecific">
                                        <h6 for="browserSearch" class="tm-color-primary" style="padding:5px ; font-size: 15px">Find the contact for a specific staff member</h6>
                                        <div class="form-group">

                                            <input type="search" name="username" id="usernameFromStudent" placeholder="Search by username" required />
                                        </div>
                                        <div class="form-group form-button">
                                            <button type="button" name="searchSubmitSpecific" class="btn btn-info" id="searchSubmitSpecific"  >Search</button>
                                        </div>
                                    </form>
                                    <!--search by subject-->
                                    <form method="POST" class="Search_formClass" style="padding: 5px" id="Search_form">
                                        <h6 for="browserSearch" class="tm-color-primary" style="padding:5px ; font-size: 15px">Find staff of each subject</h6>
                                        <div class="form-group" id="subjectPartSearch">

                                            <input list="subjectListSearch" placeholder="Choose..." name="subjId" id="subjectValueSearch" required>

                                            <datalist id="subjectListSearch">
                                                <%
                                                    if (!subjectList.isEmpty()) {
                                                        for (int i = 0; i < subjectList.size(); i++) {
                                                %>

                                                <option value="<%= subjectList.get(i).getName()%>" required >
                                                    <%
                                                            }
                                                        }
                                                    %>
                                            </datalist>
                                        </div>
                                        <div class="form-group form-button">
                                            <button type="button" name="searchSubmitSubject" class="btn btn-info" id="searchSubmitSubject"  >Search</button>
                                        </div>
                                    </form>


                                </div>
                                <div class="tm-bg-black-transparent tm-intro">
                                    <h2 class="tm-section-title mb-5 text-uppercase tm-color-primary"></h2>
                                    <p id="resultSearch1S" style="color: white ; font-size: 17px ; font-family: inherit" ></p>
                                    <p id="resultSearch2S"  style="color: white ; font-size: 17px ; font-family: inherit" ></p>
                                    <p id="resultSearch3S"  style="color: white ; font-size: 17px ; font-family: inherit" ></p>


                                </div>




                            </section>
                        </div>
                    </div>

                    <div class="tm-section-wrap bg-white">

                        <section id="Reservations" class="row tm-section">

                            <div class="col-xl-12">
                                <h1 class="tm-brand text-uppercase">Reservations</h1>
                                <div class="w-100 tm-double-border-1 tm-border-gray">
                                    <div class="tm-double-border-2 tm-border-gray ">
                                        <div class="tm-section-half">
                                            <div class="">
                                                <table class="table table-dark">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">ID</th>
                                                            <th scope="col">Date</th>
                                                            <th scope="col">From</th>
                                                            <th scope="col">To</th>
                                                            <th scope="col">Staff Member</th>
                                                            <th scope="col">Action2</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                            office_hours OH = new office_hours();
                                                            user u2 = new user();
                                                            System.out.println("office_hoursList*****" + office_hoursList);
                                                            if (!reservationList.isEmpty()) {
                                                                for (int i = 0; i < reservationList.size(); i++) {
                                                                    OH = pro.getOHById(office_hoursList, reservationList.get(i).getOffice_hoursId());
                                                                    u2 = pro.getUserById(userList, reservationList.get(i).getUserIdTo());
                                                                    System.out.println("OHHHH" + OH);
                                                                    System.out.println("U222" + u2);
                                                        %>
                                                        <tr>
                                                            <td> <%= reservationList.get(i).getReservitionId()%> </td>
                                                            <td> <%= OH.getDate()%> </td>
                                                            <td><%= OH.getFrom()%></td>
                                                            <td><%= OH.getTo()%></td>
                                                            <td><%= u2.getUsername()%></td>
                                                    <form>
<!--                                                        <input type="hidden" id="reservationsIDOH" value="<%--  --%>" >
                                                            <input type="hidden" id="reservationsCancleIDOH" value="<%--  --%>" >-->
                                                        <td> <button id="reservationsCancle" onclick="CancleBooking(<%= reservationList.get(i).getReservitionId()%>,<%= OH.getOffice_hoursId()%>)"  type="button" class="btn btn-danger">Cancel</button> </td>
                                                    </form>
                                                    </tr>
                                                    <%

                                                            }
                                                        }
                                                    %>
                                                    </tbody>
                                                </table>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br><br>
                            <div class="col-xl-12 mb-5" style="margin-top: 20px" id="resultViewRes">
                                <!--view Reservations-->
                            </div>

                        </section>
                    </div>



                    <div class="tm-section-wrap bg-white">
                        <section id="OH" class="row tm-section">
                            <div class="col-12">
                                <h1 class="tm-brand text-uppercase">office hours for Staff</h1>
                                <div class="w-100 tm-double-border-1 tm-border-gray">
                                    <div class="tm-double-border-2 tm-border-gray tm-box-pad">

                                        <form method="POST" class="Search_formClass" style="padding: 5px" id="Search_formOH">
                                            <h6 for="browserSearch" class="tm-color-primary" style="padding:5px ; color: #0b0b0b ; font-size: 15px">Write the staff member to View the office hours schedule</h6>
                                            <div class="form-group">

                                                <input type="search" name="username" id="usernameStaffOH" placeholder="Search by username" required />
                                            </div>
                                            <div class="form-group form-button">
                                                <button type="submit" name="searchSubmitOH" class="btn btn-info" id="searchSubmitOH"  >View</button>
                                            </div>
                                        </form>

                                        <%
                                            user StaffOH = new user();
                                            StaffOH.setUserId(0);
                                            if (session.getAttribute("staffuserOH") != null) {
                                                StaffOH = (user) session.getAttribute("staffuserOH");

                                                if (StaffOH.getUserId() == -1) {


                                        %>

                                        <p> <%= StaffOH.getUsername()%>  </p>

                                        <%}
                                            }%>

                                        <%
                                            if (StaffOH.getUserId() != 0 && StaffOH.getUserId() != -1 && StaffOH.getType().equals("staff")) {


                                        %>

                                        <h6 class="tm-brand"> Staff Name: <%= StaffOH.getUsername()%> </h6>

                                        <div class="">
                                            <table class="table table-dark">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Id</th>
                                                        <th scope="col">Date</th>
                                                        <th scope="col">From</th>
                                                        <th scope="col">To</th>
                                                        <th scope="col">Appointment Booking</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <%   if (!office_hoursList.isEmpty()) {
                                                            for (int i = 0; i < office_hoursList.size(); i++) {
                                                                if (office_hoursList.get(i).getUserId() == StaffOH.getUserId()) {


                                                    %>
                                                    <tr>
                                                        <td> <%=  office_hoursList.get(i).getOffice_hoursId()%> </td>
                                                        <td><%= office_hoursList.get(i).getDate().toString()%></td>
                                                        <td> <%= office_hoursList.get(i).getFrom().toString()%> </td>
                                                        <td><%= office_hoursList.get(i).getTo().toString()%></td>
                                                        <%
                                                            if (office_hoursList.get(i).isReserved() == 0) {
                                                        %>
                                                <form>
                                                    <input type="hidden" id="office_hoursIDBOOKING" value="<%= office_hoursList.get(i).getOffice_hoursId()%>" >
                                                    <input type="hidden" id="StudID" value="<%= u.getUserId()%>" >
                                                    <td> <button id="office_hoursBooking" onclick="BookingOH(<%= office_hoursList.get(i).getOffice_hoursId()%>,<%= u.getUserId()%>)" type="button" class="btn btn-info">Appointment Booking</button> </td>
                                                </form>
                                                <%} else {%>
                                                <td> <button id="" type="button" disabled  class="btn btn-info">Appointment Booking</button> </td>
                                                <%}%>
                                                </tr>
                                                <%
                                                            }
                                                        }
                                                    }
                                                %>
                                                </tbody>
                                            </table>
                                        </div>
                                        <%}%>
                                    </div>
                                </div>

                            </div>



                        </section>
                    </div>
                    <div class="tm-section-wrap bg-white ">
                        <section id="notifications" class="row tm-section">
                            <h1 class="tm-brand text-uppercase">
                                notifications
                            </h1>
                            <div class="col-12 tm-section-pad">
                                <div class="tm-flex-item-left overflow-auto"  style="max-width: 800px; max-height: 400px;">
                                    <%
                                        if (!notificationList.isEmpty()) {
                                            for (int i = notificationList.size() - 1; i >= 0; i--) {
                                    %>
                                    <div class="tm-w-80 tm-double-border-1 tm-border-gray" style="background-color: #454d55 ; color: white">
                                        <div class="tm-double-border-2 tm-border-gray"  >
                                            <ul class="notifications">
                                                <li class="notification">
                                                    <div class="media">
                                                        <div class="media-left">
                                                        </div>
                                                        <div class="media-body">
                                                            <strong class="notification-title"><%= notificationList.get(i).getMassage()%></strong>
                                                            <p class="notification-desc" style="color:darkgoldenrod" ><%= notificationList.get(i).getMassage()%></p>
                                                            <div class="notification-meta">
                                                                <small class="timestamp"> <%= notificationList.get(i).getDate()%></small>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <%}
                                        }%>
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="tm-section-wrap bg-white">

                        <h1 class="tm-brand text-uppercase">
                            messages
                        </h1>

                        <section id="messages" class="row tm-section">



                            <div class="col-xl-7 mb-5">

                                <div class="col-12 tm-section-pad">
                                    <div class="tm-flex-item-left overflow-auto"  style="max-width: 800px; max-height: 400px;">
                                        <%
//                                            processes pro = new processes();
                                            user sendUser = new user();
                                            if (!messageList.isEmpty()) {
                                                for (int i = messageList.size() - 1; i >= 0; i--) {
                                                    boolean f = false;
                                                    if (messageList.get(i).getUserIdFrom() != u.getUserId()) {
                                                        sendUser = pro.getUserById(userList, messageList.get(i).getUserIdFrom());
                                                    } else {
                                                        sendUser = pro.getUserById(userList, messageList.get(i).getUserIdTo());
                                                        f = true;
                                                    }
                                        %>


                                        <ul class="messages">

                                            <li class="message">
                                                <div class="media">
                                                    <div class="media-left">
                                                    </div>
                                                    <div class="media-body">
                                                        <% if (f) {%>
                                                        <p> Massage From  <strong class="message-title" style="color: blueviolet"> You </strong> To <strong class="message-title" style="color: blueviolet"> <%= sendUser.getUsername()%> </strong> </p>
                                                        <%} else {%>
                                                        <p> Massage From  <strong class="message-title" style="color: blueviolet"><%= sendUser.getUsername()%> </strong> To <strong class="message-title" style="color: blueviolet"> You </strong> </p>
                                                        <%}%>
                                                        <p class="message-desc" style="color:darkgoldenrod" ><%= messageList.get(i).getActualMessage()%></p>
                                                        <div class="message-meta">
                                                            <small class="timestamp"> <%= messageList.get(i).getDate()%></small>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>

                                        </ul>

                                        <%}
                                            }%>


                                    </div>
                                </div>
                            </div>


                            <div class="col-xl-5 mb-5">
                                <div class="tm-contact-form-wrap">
                                    <form action="" method="POST" class="tm-contact-form">
                                        <div style="margin: 10px">
                                            <p>Select whom you want to email</p>
                                            <div class="form-group click " style="margin-bottom: 2px">
                                                <label >Subject Team</label>
                                                <input type="radio" id="TeamMessage" name="typeMessage" value="TeamMessage" required> 
                                                <!--<input  type="radio" id="specificMessage" name="typeMessage" value="specificMessage" required> Specific Message-->
                                            </div>

                                            <div class="form-group click" style="margin-bottom: 2px">
                                                <label >Specific Message</label>
                                                <input  type="radio" id="specificMessage" name="typeMessage" value="specificMessage" required>
                                            </div>
                                        </div>

                                        <%
//                                            subjectDao SDao = new subjectDao();
//                                            List<subject> subjectList = new ArrayList();
//                                            subjectList = SDao.getAllSubject();
                                        %>
                                        <div class="form-group" hidden="false" id="subjectPart">
                                            <label for="browser">Choose Subject Team :</label><br><br>
                                            <input list="subjectList" name="subjId" id="subjectValue" required>

                                            <datalist id="subjectList">
                                                <%  if (!subjectList.isEmpty()) {
                                                        for (int i = 1; i < subjectList.size(); i++) {
                                                            System.out.println(subjectList.get(i).getName());
                                                %>

                                                <option value="<%= subjectList.get(i).getName()%>" required >
                                                    <%
                                                            }
                                                        }
                                                    %>
                                            </datalist>
                                        </div>

                                        <div class="form-group">

                                            <input type="email" class="form-control" hidden="false" id="emailPart" required placeholder="name@example.com">
                                        </div>
                                        <div class="form-group">
                                            <textarea rows="4" id="contactMessage" required name="contactMessage" class="form-control rounded-0 border-top-0 border-right-0 border-left-0" placeholder="Message..." required=""></textarea>
                                        </div>
                                        <div class="form-group mb-0">
                                            <button type="button" onclick="SendMessage(<%= u.getUserId()%>)" class="btn rounded-0 d-block ml-auto tm-btn-primary">
                                                SEND
                                            </button>


                                        </div>
                                    </form>
                                </div>
                            </div>
                        </section>
                    </div>
                </main>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.singlePageNav.min.js"></script>
        <script src="js/parallax.min.js"></script>
        <script src="slick/slick.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/templatemo-scripts.js"></script>
        <script src="js/studentjs.js"></script>
        <script src="js/massagejs.js"></script>
</body>

</html>

<%}%>