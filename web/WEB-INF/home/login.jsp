<%-- 
    Document   : login
    Created on : Jun 20, 2015, 10:21:28 PM
    Author     : Larry_Lite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to Time T Pro</title>
    </head>
    <body>
        <h2 style="text-align: center">Login with your account</h2>
        <div class="" style="text-align: center">
            <form action="Login" method="post" class="form-horizontal" role="form">
                <p>
                <input placeholder="enter your email" id="email" name="email" type="email" />
                </p>
                <p>
                    <input placeholder="Enter password" id="password" name="password" type="password" />
                </p>
                <select name="role" id="role">
                    <option value="0">LECTURER</option>
                    <option value="1">HOD</option>
                    <option value="2">DEAN</option>
                </select>
                <input type="submit" name="submit" id="submit" value="Login"/>
                    
            </form>
            
        </div>
        <footer>
            Powered By IceTeck Inc. 2015
        </footer>
    </body>
</html>
