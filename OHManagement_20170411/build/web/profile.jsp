<%-- 
    Document   : profile
    Created on : Jan 16, 2021, 9:29:33 PM
    Author     : Moaaz Hasan
--%>

<%@page import="Controller.processes"%>
<%@page import="Model.user"%>
<%@page import="Model.subject"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.subjectDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    user u = new user();
    if (session.getAttribute("user") == null) {
        request.getRequestDispatcher("index.jsp").include(request, response);
    } else {
        u = (user) session.getAttribute("user");

%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>profile</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        
    </head>

    <script>

        function SaveChanges() {

            var Dname = document.getElementById("displayNameEdit").value;
            var email = document.getElementById("emailEdit").value;
            var password = document.getElementById("passwordEdit").value;
            var confirmPassword = document.getElementById("passwordConfirmEdit").value;
            var subj = -1;
        <% if (u.getType().equals("staff")) { %>
             subj = document.getElementById("subjectValueEdit").value;
        <%}%>

//            if (passowrd != '') {
                if (password != confirmPassword) {
                    alert("Confirm Password dosen't match password!!");
                    return;
                }
//            }
            var url = "saveEditProfile?Dname="+Dname+"&email="+email+"&password="+password+"&subj="+subj+"&userId="+<%=u.getUserId()%>;
//            alert(url);
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open("GET", url, true);
            xmlhttp.send();
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    window.alert(xmlhttp.responseText);
                }
            }

        }



    </script>

    <body>

        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">

                <div class="col-md-12 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-12">
                                <label class="labels">username</label>
                                <input type="text" disabled class="form-control" placeholder="username" value="<%= u.getUsername()%>">
                            </div>
                            <div class="col-md-12">
                                <label class="labels">Display Name</label>
                                <input type="text"  id="displayNameEdit"  class="form-control" placeholder="display Name" value="<%= u.getDisplayName()%>">
                            </div>
                        </div>
                        <div class="row mt-1">
                            <div class="col-md-12">
                                <label  class="labels">Email</label>
                                <input type="text"  class="form-control" required  id="emailEdit" placeholder="enter email" value="<%= u.getEmail()%>">
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-6">
                                <label  class="labels">Password</label>
                                <input type="password" id="passwordEdit" class="form-control" placeholder="New password" value="">
                            </div>
                            <div class="col-md-6">
                                <label class="labels">Confirm Password</label>
                                <input type="password" id="passwordConfirmEdit"  class="form-control" placeholder="Rewrite password" value="">
                            </div>
                        </div>
                        <% if (u.getType().equals("staff")) { %>
                        <div class="row mt-2">
                            <%
                                processes pro = new processes();
                                subjectDao SDao = new subjectDao();
                                List<subject> subjectList = new ArrayList();
                                subjectList = SDao.getAllSubject();
                                subject s = pro.getSubjectBySubjId(subjectList, u.getSubjectId());
                            %>
                            <div class="col-md-6 " id="subjectPart">
                                <label  for="browser">Subject </label>
                                <input list="subjectList" name="subjId" id="subjectValueEdit" value="<%= s.getName()%>" >

                                <datalist id="subjectList">
                                    <%  if (!subjectList.isEmpty()) {
                                            for (int i = 0; i < subjectList.size(); i++) {
                                                System.out.println(subjectList.get(i).getName());
                                    %>
                                    <option value="<%= subjectList.get(i).getName()%>" required >
                                        <%
                                                }
                                            }
                                        %>
                                </datalist>
                            </div>
                        </div>
                        <%}%>



                        <div class="mt-5 text-center">
                            <button class="btn btn-primary profile-button" onclick="SaveChanges()" type="button">Save</button>
                        </div>
                        <%
                            if (u.getType().equals("staff")) {
                        %>
                        <a href="staffPage.jsp" class="signup-image-link ">Back To Home</a>
                        <%} else {%>
                        <a href="studentPage.jsp" class="signup-image-link ">Back To Home</a>
                        <%}%>
                    </div>
                </div>


            </div>
        </div>



    </body>

</html>

<%}%>