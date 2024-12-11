<%-- 
    Document   : login
    Created on : Dec 7, 2024, 4:52:56 PM
    Author     : ngoct
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="CSS/style.css"/>
    </head>
    <body>
        <h1>Login form</h1>
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
        <p style="color: red"> <%= error%> </p>
        <%
            }
        %>

        <form action="" method="post">
            <div>
                <div>
                    <label for="inputUsername">Username</label> 
                    <input type="text" id="inputUsername" name="username" placeholder="Enter username"/>
                </div>
                <div>
                    <label for="inputPassword">Password</label>
                    <input type="password" id="inputPassword" name="pass" />
                </div>
                <div class="style">
                    <div><button type="submit">Login</button></div>

                    <div><a href="register">Register</a></div>
                </div>
            </div>
        </form>
    </body>
</html>
