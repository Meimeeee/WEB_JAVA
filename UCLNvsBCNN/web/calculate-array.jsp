<%-- 
    Document   : calculate-array
    Created on : Dec 4, 2024, 2:07:47 PM
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
            Integer result = (Integer) request.getAttribute("result");
            String input = request.getParameter("input");
        %>


        <div>
            <h1>Tinh toan voi mang</h1>

            <%
                if (error != null) {
            %>
                <p style="color: red"> <%=error%> </p>
            <%
                }
            %>

            <form action="" method="post">
                <div>
                    <label for="ketquaInput">Ket qua</label>
                    <input type="text" id="ketquaInput" readonly value="<%=result != null ? result : ""%>"/>
                </div>
                <div>
                    <label for="mangInput">Nhap mang a:</label>
                    <input type="text" id="mangInput" placeholder="Vi du: 1,2,3,4,5" name="input" value="<%=input != null ? input : ""%>"/>
                </div>
                <div>
                    <button type="submit" name="func" value="sum">Tong cua mang</button>
                    <button type="submit" name="func" value="max">Phan tu lon nhat</button>
                </div>
            </form>
        </div>        
    </body>
</html>
