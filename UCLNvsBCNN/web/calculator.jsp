<%-- 
    Document   : calculator
    Created on : Dec 4, 2024, 9:45:19 AM
    Author     : longlt201203
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculator</h1>
        <form action="" method="post">
            <div>

                <%
                    String aStr = request.getParameter("a");
                    String bStr = request.getParameter("b");

                    Integer result = (Integer) request.getAttribute("result");

                    String error = (String) request.getAttribute("error");
                %>

                <%
                    if (error != null) {
                %>

                <p style="color: red"><%=error%></p>

                <%
                    }
                %>

                <label for="ketquaInput">Ket qua</label>
                <input type="text" id="ketquaInput" readonly value="<%=result != null ? result : ""%>"/>
            </div>
            <div>
                <label for="aInput">Nhap a</label>
                <input type="text" placeholder="Nhap a" id="aInput" name="a" value="<%=aStr != null ? aStr : ""%>"/>
            </div>
            <div>
                <label for="bInput">Nhap b</label>
                <input type="text" placeholder="Nhap b" id="bInput" name="b" value="<%=bStr != null ? bStr : ""%>"/>
            </div>
            <div>
                <button type="submit" name="operation" value="ucln">UCLN</button>
                <button type="submit" name="operation" value="bcnn">BCNN</button>
            </div>
        </form>
    </body>
</html>