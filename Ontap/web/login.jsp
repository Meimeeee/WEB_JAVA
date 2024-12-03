<%-- 
    Document   : loginJSP
    Created on : Dec 1, 2024, 1:33:56 PM
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

        <%  //nhập code java
            String error = (String) request.getAttribute("error");
            String userName = request.getParameter("username"); // mặc định kiểu String
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
        <form method="post" action="">
            <h3>This is login page</h3>
            <div class="form-control">
                <label for="UsernameInput">Username</label>
                <input 
                    type="text" 
                    id="UsernameInput" 
                    name="username"
                    placeholder="Enter Username"
                    value = "<%=userName!= null ? userName : ""%>"
                    />
            </div>
            <div class="form-control">
                <label for="passwordInput">Password</label>
                <input 
                    type="password" 
                    name="password" 
                    id="passwordInput"
                    placeholder="Enter Password" 
                    />
            </div> 
            <div class="form-control">
                <br>
                <button type="submit">Login</button>
                <button type="reset">Reset</button>
                <hr>
            </div>
            <div></div>
        </form>
    </body>
</html>
