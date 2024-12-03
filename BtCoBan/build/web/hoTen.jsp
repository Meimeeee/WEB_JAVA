<%-- 
    Document   : index
    Created on : Dec 2, 2024, 6:29:53 PM
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
        <div>
            <form action="" method ="post">
                <!-- Khi ấn Submit thì sang result.jsp -->
                <h1>Enter Information</h1>

                <%
                    String error = (String) request.getAttribute("error");
                    String name = (String) request.getParameter("name");
                    String ageStr = (String) request.getParameter("age");
                %>

                <%
                    if (error != null) {
                %>
                    <p style="color: red"><%=error%></p>
                <%
                    }
                %>

                <label for="nameInput">Full name</label>
                <input type="text" name="name" id="nameInput"><br>

                <label for="ageInput">Age</label>
                <input type="number" name="age" id="ageInput"><br>
                <button type="submit">Submit</button>
                <hr>

                <%
                    if (name != null && ageStr != null) {
                        if (Integer.parseInt(ageStr) > 0) {
                %>


                    <p>Kết quả:</p>
                    <p>Họ và tên: <%=name%></p>
                    <p>Tuổi: <%= ageStr%></p>
                <%
                    } else {
                %>
                    <p style="color: red">Age must larger than 0</p>
                <%
                        }
                    }
                %>
            </form>
        </div>
    </body>
</html>