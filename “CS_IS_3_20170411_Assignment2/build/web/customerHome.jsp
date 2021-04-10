<%-- 
    Document   : login
    Created on : Dec 19, 2020, 6:33:16 PM
    Author     : Moaaz Hasan
--%>

<%@page import="Model.Customer"%>
<%@page import="Model.BankAccount"%>
<%@page import="Dao.bankAccountDao"%>
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
        <title>Home</title>
    </head>
    <body>
        <section class="sign-in">
            <div class="container">
                <%
                    Customer customer = null;
                    if (session != null) {
                        customer = (Customer) session.getAttribute("customer");

                        out.print(" <div style='padding-left: 50px'><h1> Hello, " + customer.getCustomerName() + "</h1></div>");
                    } else {
                        request.getRequestDispatcher("index.jsp").include(request, response);
                    }
                %>
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="images/signin-image.jpg" alt="sing up image"></figure>
                        <a href="index.jsp" class="signup-image-link">Logout</a>
                    </div>


                    <%
                        BankAccount bankAccount = null;
                        bankAccountDao bCAcountDao = new bankAccountDao();

                        bankAccount = bCAcountDao.SelectUserAccount(customer.getCustomerId());

                        if (bankAccount != null) {
                    %>
                    <form method="POST" style="margin-right:30px" ><br><br>
                        <div class="form-group form-button">
                            <input style="background-color: gray" type="submit" name="signin" id="signin" class="form-submit" disabled value="Add Account"/>
                        </div>
                        <div>
                            <h3>Your Amount is <%= bankAccount.getCurrentBalance()%> </h3>
                            <a href="Transaction.jsp" class="signup-image-link">Transaction</a>
                        </div>
                    </form>


                    <%  } else {%>
                    <form method="POST" action="addAccount" >
                        <div class="form-group form-button">
                            <input type="hidden" name="IdToAdd" value="${customer.getCustomerId()}" />
                            <input type="submit" name="signin" id="signin" class="form-submit" value="Add Account"/>
                        </div>
                    </form>
                    <%}%>

                </div>


            </div>
        </section>
    </body>
</html>
