<%-- 
    Document   : login
    Created on : Dec 19, 2020, 6:33:16 PM
    Author     : Moaaz Hasan
--%>

<%@page import="com.sun.xml.wss.util.DateUtils"%>
<%@page import="Dao.bankTransactionDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.BankTransaction"%>
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

                    List<BankTransaction> bankTransactionList = new ArrayList();
                    bankTransactionDao BTDao = new bankTransactionDao();
                    bankTransactionList = BTDao.SelectTransactionsList(customer.getCustomerId());

                %>
                <div class="signin-content">
                    <div class="signin-image" style="width: 80%">
                        <div>
                            <table cellspacing="8" cellpadding="6" style="font-size: 12px" >
                                <tr><th>ID</th><th>Date</th><th>Amount</th><th>From</th><th>To</th><th>Cancel</th></tr>
                                        <%// Iterating through subjectList
                                            int n = 0;

                                            while (n < bankTransactionList.size()) // iterate through all the data until the last record
                                            {
                                                BankTransaction BT = null;
                                                BT = bankTransactionList.get(n++);
                                        %>
                                <tr>
                                    <td><%=BT.getBankTransactionId()%></td>
                                    <td><%=BT.getCreationDate()%></td>
                                    <td><%=BT.getAmount()%></td>
                                    <td><%=BT.getFromAccount()%></td>
                                    <td><%=BT.getToAccount()%></td>
                                    <td>
                                        <%
                                            java.util.Date date = new java.util.Date();
                                            java.sql.Date DateNow = new java.sql.Date(date.getTime());

                                            if (DateNow.getDate() == BT.getCreationDate().getDate() && customer.getCustomerId() == BT.getFromAccount()  ) {

                                        %>
                                        <form method="POST" action="CancelTransaction">
                                            <div >
                                                <input type="hidden" name="IdTrans"  value="<%= BT.getBankTransactionId()%>" />
                                                <input type="submit" name="trans" value="Cancel" />
                                            </div>
                                        </form>
                                        <%                                        } else {
                                        %>
                                        <form>
                                            <div >
                                                <input type="submit" name="trans" disabled value="Cancel" />
                                            </div>
                                        </form>
                                        <%
                                            }
                                        %>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </table>

                        </div>
                        <br><br><a href="customerHome.jsp" class="signup-image-link">Back Home</a>
                    </div>


                    <%
                        BankAccount bankAccount = null;
                        bankAccountDao bCAcountDao = new bankAccountDao();
                        bankAccount = bCAcountDao.SelectUserAccount(customer.getCustomerId());
                    %>

                    <div class="signin-form">
                        <h2 class="form-title">Transaction</h2>
                        <form method="POST" class="register-form" id="login-form" action="AddTransaction">
                             <div class="form-group">
                                <input type="hidden" name="from" id="intager" value="${customer.getCustomerId()}" />
                            </div>
                            <div class="form-group">
                                <input type="text" name="amount" id="intager" placeholder="Enter Amount" required />
                            </div>
                            <div class="form-group">
                                <input type="text" name="to" id="intager" placeholder="To who? (ID ACCOUNT)" required />
                            </div>
                           
                            <div class="form-group form-button">
                                <input type="submit" name="trans" id="signin" class="form-submit" value="Make Transfer"/>
                            </div>
                        </form>
                        <p> ${message}</p>
                        <c:remove var="message" scope="session" />
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
