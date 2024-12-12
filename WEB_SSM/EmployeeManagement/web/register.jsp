<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>
    <body>
        <h1>Register</h1>

        <%
            String error = (String) request.getAttribute("error");
        %>
        <c:if test="${requestScope.error != null}">
            <p style="color: crimson">${requestScope.error}</p>
        </c:if>


        <form action="" method="post">
            <section>
                <div class="form-control">
                    <label for="UsernameInput">Username<br></label>
                    <input type="text" 
                           name="username" 
                           id="UsernameInput"
                           placeholder="Enter Username"
                           />
                </div>
                <div class="form-control">
                    <label for="password">Password<br></label>
                    <input type="password" 
                           name="pass" 
                           id="password"
                           placeholder="Enter Password"
                           />
                </div>
                <div class="form-control">
                    <label for="confirm-password">Confirm password<br></label>
                    <input type="password" 
                           name="confirmPassword" 
                           id="confirm-password"
                           placeholder="Confirm Password"
                           />
                </div>
                <div class="form-control">
                    <br>
                    <button type="submit">Accept</button>
                    <button type="reset">Reset</button>
                </div>
            </section>