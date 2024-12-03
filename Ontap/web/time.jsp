<%-- 
    Document   : time
    Created on : Dec 1, 2024, 1:25:19 PM
    Author     : ngoct
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String currentTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        %>

        <h1>Current time:</h1>

        <p>Current time: <%=currentTime%></p>
    </body>
</html>
