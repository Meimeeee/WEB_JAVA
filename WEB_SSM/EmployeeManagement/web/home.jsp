<%@page import="DTO.positionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.employeeDAO"%>
<%@page import="java.util.List"%>
<%@page import="DTO.employeeDTO"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="../CSS/style.css">
    </head>

    <body>

        <%
            List<employeeDTO> employees = (List<employeeDTO>) request.getAttribute("employees");
            if (employees == null) {
                employees = new ArrayList<employeeDTO>();
            }

            List<positionDTO> positions = (List<positionDTO>) request.getAttribute("positions");
            if (positions == null) {
                positions = new ArrayList<positionDTO>();
            }
            String error = (String) request.getAttribute("error");
        %>

        <div style="background-color: burlywood;">
            <h1 style="text-align: center">Employee Management</h1>

            <%
                if (error != null) {
            %>
            <h3 style="color: #ff3333"> <%= error%></h3>
            <%
                }
            %>

            <div style="display: grid; grid-template-columns: 50% 50%;">
                <form action="" method="post">
                    <h2>Add Employee</h2>
                    <div class="add" style="display: grid; row-gap: 2px;">
                        <div>
                            <label for="inputName">Name</label>
                            <input type="text" id="inputName" name="name" required/>
                        </div>
                        <div>
                            <label for="selectPosition">Position</label>
                            <select id="selectPosition" name="position">
                                <%
                                    for (positionDTO position : positions) {
                                %>
                                <option value="<%= position.getPositionID()%>"> <%= position.getPositionName()%> </option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div>
                            <label for="inputMail">Gmail</label>
                            <input type="email" id="inputMail" name="mail" placeholder="example@gmail.com" required/>
                        </div>
                        <div>
                            <label for="inputPhone">Phone</label>
                            <input type="tel" id="inputPhone" name="phone" pattern="[0-9]{10,12}" placeholder="12345678902" required>
                        </div>
                        <div>
                            <button type="submit" name="func" value="add">Save</button>
                        </div>
                    </div>
                </form>

                <form action="" method="post">
                    <h2>Update Employee Information</h2>
                    <div class="update" style="display: grid; row-gap: 2px;">
                        <div>
                            <label for="selectEmployee">Id Employee</label>
                            <select id="selectEmployee" name="employeeID">
                                <%
                                    for (employeeDTO employee : employees) {
                                %>
                                <option value="<%= employee.getEmployeeID() %>"><%= employee.getEmployeeID()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div>
                            <label for="inputName">Name</label>
                            <input type="text" id="inputName" name="name" />
                        </div>
                        <div>
                            <label for="">Position</label>
                            <select id="selectPosition" name="position">
                                <%
                                    for (positionDTO position : positions) {
                                %>
                                <option value="<%= position.getPositionID()%>"> <%= position.getPositionName()%> </option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div>
                            <label for="inputMail">Gmail</label>
                            <input type="email" id="inputMail" name="mail" placeholder="example@gmail.com" />
                        </div>
                        <div>
                            <label for="inputPhone">Phone</label>
                            <input type="tel" id="inputPhone" name="phone" pattern="[0-9]{10,12}" placeholder="12345678902"/>
                        </div>
                        <div>
                            <button type="submit" name="func" value="update">Save</button>
                            <button type="reset">Reset</button>
                        </div>
                    </div>
                </form>
            </div>
            <div style="width: 768px;">
                <form action="" method="post">
                    <h2>List Employee</h2>
                    <div class="list" style="display: grid">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Phone</th>
                                    <th>Mail</th>
                                    <th>Position</th>
                                    <th>Salary</th>
                                    <tH></tH>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (employeeDTO employee : employees) {
                                %>
                                <tr>
                                    <td> <%= employee.getEmployeeID()%> </td>
                                    <td> <%= employee.getEmployeeName()%> </td>
                                    <td> <%= employee.getPhone()%> </td>
                                    <td> <%= employee.getMail()%> </td>
                                    <td> <%= employee.getPositionID()%> </td>
                                    <td> <%= employee.getSalary()%> </td>
                                    <td>
                                        <form action="" method="post">
                                            <input type="hidden" name="employeeID" value="<%= employee.getEmployeeID()%>"/>
                                            <button type="submit" name="func" value="delete">Delete</button>
                                        </form>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>

                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>