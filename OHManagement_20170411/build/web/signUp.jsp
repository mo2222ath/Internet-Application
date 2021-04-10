<%-- 
    Document   : signUp
    Created on : Dec 29, 2020, 11:30:25 AM
    Author     : Moaaz Hasan
--%>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.subjectDao"%>
<%@page import="org.hibernate.Session"%>
<%@page import="Model.subject"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">


        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
        <title>Sign Up</title>
        <script type="text/javascript">
            var verifyCallback = function (response) {
//                alert(response);
                var response2 = grecaptcha.getResponse();
                if(response2.length != 0){
                    alert("Faild register , be sure of Verify ReCaptcha!");
                    return;
                }
                alert(response2.length);
            };
            var widgetId1;
            var onloadCallback = function () {
                widgetId1 = grecaptcha.render('example1', {
                    'sitekey': '6Lc-DzEaAAAAANkdVo-yBIszyeRhdNZCsf4KrKJp',
                    'callback' : verifyCallback,
                    'theme': 'light'
                });
                
            };
        </script>

    </head>

    <body>
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form  method="POST" action="javascript:alert(grecaptcha.getResponse(widgetId1));" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="username" id="username" placeholder="username" oninput="checkUsername()" required />
                                <p style="color: red" id="show_responseUsername"></p>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your Email" oninput="checkEmail()" required/>
                                <p style="color: red" id="show_responseEmail"></p>
                            </div>
                            <div style="display: inline;">
                                <p>Are You Saff or Student?</p><br>
                                <div class="form-group click" style="margin-bottom: 2px">
                                    <input type="radio" id="staffRadio" name="type"  value="staff" required>
                                    <label for="staff">Staff</label>
                                </div>
                                <div class="form-group click" style="margin-bottom: 2px">
                                    <input  type="radio" id="studentRadio" name="type" value="student" required>
                                    <label for="student">Student</label><br>
                                </div>
                            </div>
                            <%
                                subjectDao SDao = new subjectDao();
                                List<subject> subjectList = new ArrayList();
                                subjectList = SDao.getAllSubject();
                            %>
                            <div class="form-group" id="subjPart" hidden="true" >
                                <label for="browser">Choose your Subject only if you from Staff :</label><br><br>
                                <input list="subjectList" id="subjId" name="subjectBrowser" id="browser" required>

                                <datalist id="subjectList">
                                    <%  for (int i = 1; i < subjectList.size(); i++) {
                                    %>
                                    <option value="<%= subjectList.get(i).getName()%>"  >
                                        <%
                                            }
                                        %>
                                </datalist>
                            </div>
                            <!--<div class="g-recaptcha" data-sitekey="6Lc-DzEaAAAAANkdVo-yBIszyeRhdNZCsf4KrKJp"></div>-->
                            <div id="example1"></div>
                            <div class="form-group form-button">
                                <input type="submit" onclick="Signup()" name="signup" 
                                       id="signup" class="form-submit" value="Register"/>
                            </div>
                        </form>

                    </div>
                    <div class="signup-image">
                        <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="index.jsp" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>
    </body>
    <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
        async defer>
    </script>

    <script src="js/signupjs.js"></script>
    <script src="https://www.google.com/recaptcha/api.js"></script>

</html>
