<%-- 
    Document   : newjsp
    Created on : Dec 1, 2024, 3:49:41 PM
    Author     : ngoct
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            String error = (String) request.getAttribute("error");
            String username = request.getParameter("userName");
        %>

        <h1>Login</h1>

        <%
            if (error != null) {
        %>
        
        <p>
            <%=error%>
        </p>
        
        <%
            }
        %>

       
        <form method = "post" action="">
            <div class="form-control">
                <label for = "usernameInput">Username</label>
                <input type="text" id ="usernameInput" name="username" value="<%=username!=null ? username : ""%>"/>
            </div>

            <div class="form-control">
                <label for="passwordInput">Password</label>
                <input type="password" id="passwordInput" name="password"
            </div>

            <div>
                <br>
                <button type="submit">Login</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
