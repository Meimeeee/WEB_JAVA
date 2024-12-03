<%-- 
    Document   : calculator
    Created on : Dec 2, 2024, 8:06:45 PM
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
            String nfe = (String) request.getAttribute("nfe");
        %>

        <form method="post" action="">
            <h2>CALCULATE</h2>

            <%
                if (nfe != null) {
            %>

            <p style="color: red"> <%=nfe%> </p>

            <%
                }
            %>

            <div class="form-control">
                <label for="aInput">First num </label>
                <input type="text" id="aInput" name="a" required><br>
            </div>

            <div class="form-control">
                <label for="bInput">Second num </label>
                <input type="text" id="bInput" name="b" required><br>
            </div>

            <div class="form-control">
                <label for="operation">Choose operation:</label><br>

                <button type="submit" name="operation" value="add">Add</button>
                <button type="submit" name="operation" value="sub">Subtract</button>
                <button type="submit" name="operation" value="mul">Multiply</button>
                <button type="submit" name="operation" value="div">Divide</button>
            </div>

            <div>
                <label for="Result">Result</label>
                <%
                    Double result = (Double) request.getAttribute("result");
                    if (result != null) {
                %>
                
                <%=result%>
                
                <%
                    }
                %>
            </div>

        </form>
    </body>
</html>
