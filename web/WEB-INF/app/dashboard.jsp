<%-- 
    Document   : dashboard
    Created on : Jun 20, 2015, 10:51:49 PM
    Author     : Larry_Lite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ttable.model.Lecturer" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylsheet" href="assets/css/bootstrap-theme.css" />
        <link rel="stylsheet" href="assets/css/bootstrap.css" />
        <link rel="stylsheet" href="assets/css/bootstrap.min.css" />
        <link rel="stylsheet" href="assets/css/main.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
        <% Lecturer lec = (Lecturer)request.getAttribute("lecturer"); %>
        <h1>Welcome to Mr <%= lec.getFirstName() %> </h1>
        <div class="row">
            <div class="col-lg-3">
                <ul class="navbar">
                    <li class="nav-list">
                        <a href="dashboard/ilist">Individual List</a>
                    </li>
                    <li class="nav-list">
                        <a href="dashboard/blist">Block List</a>
                    </li>
                    <li class="nav-list">
                        <a href="dashboard/list">List</a>
                    </li>
                </ul>
            </div>
            <div class="col-lg-8">
                <table class="table table-bordered table-responsive">
                    
                </table>
            </div>
                 
        </div>
        <footer> Powered By IceTeck Inc , &nbsp; &COPY;2015</footer>
    </body>
</html>
