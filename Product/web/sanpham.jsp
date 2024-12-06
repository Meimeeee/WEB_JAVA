<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="src.SanPhamDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>San Pham</title>
        <style>
            #root {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                gap: 20px;
            }

            #sanPhamControl {
                display: flex;
                flex-direction: row;
                gap: 20px;
                margin-bottom: 20px;
            }

            #sanPhamTable {
                border-collapse: collapse;
            }

            #sanPhamTable td, th {
                padding: 4px;
            }

        </style>
    </head>
    <body>

        <%
            List<SanPhamDTO> listSanPham = (List<SanPhamDTO>) request.getAttribute("listSanPham");
            if (listSanPham == null)
                listSanPham = new ArrayList<SanPhamDTO>();
        %>

        <div id="root">
            <h1>San Pham</h1>
            <div id="sanPhamControl">
                <div>
                    <h3>Them san pham</h3>
                    <form action="" method="post">
                        <div>
                            <label for="createProductNameInput">Ten san pham</label>
                            <input type="text" id="createProductNameInput" required name="productName"/>
                        </div>
                        <div>
                            <label for="createProductDescriptionInput">Mo ta</label>
                            <textarea id="createProductDescriptionInput" required name="productDescription"></textarea>
                        </div>
                        <div>
                            <label for="createProductPriceInput">Gia tien</label>
                            <input type="number" min="1000" id="createProductPriceInput" required name="productPrice"/>
                        </div>
                        <div>
                            <button type="submit" name="operation" value="them">Them</button>
                        </div>
                    </form>
                </div>
                <div>
                    <h3>Chinh sua san pham</h3>
                    <form action="" method="post">
                        <div>
                            <label for="selectProductInput">Chon san pham</label>
                            <select id="selectProductInput" name="productId">

                                <%
                                    for (int i = 0; i < listSanPham.size(); i++) {
                                        SanPhamDTO sanpham = listSanPham.get(i);

                                %>
                                <option value="<%= sanpham.getProductId()%>"><%= sanpham.getProductName()%></option>
                                <%
                                    }
                                %>

                            </select>
                        </div>
                        <div>
                            <label for="updateProductNameInput">Ten san pham</label>
                            <input type="text" id="updateProductNameInput" required name="productName"/>
                        </div>
                        <div>
                            <label for="updateProductDescriptionInput">Mo ta</label>
                            <textarea id="updateProductDescriptionInput" required name="productDescription"></textarea>
                        </div>
                        <div>
                            <label for="updateProductPriceInput">Gia tien</label>
                            <input type="number" min="1000" id="updateProductPriceInput" required name="productPrice"/>
                        </div>
                        <div>
                            <button type="submit" name="operation" value="sua">Luu</button>
                            <button type="reset">Reset</button>
                        </div>
                    </form>
                </div>
            </div>
            <div>
                <table id="sanPhamTable" border="1">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Ten san pham</th>
                            <th>Mo ta</th>
                            <th>Gia tien</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>

                        <%
                            for (int i = 0; i < listSanPham.size(); i++) {
                                SanPhamDTO sanPham = listSanPham.get(i);
                        %>
                        <tr>
                            <td><%= sanPham.getProductId()%></td>
                            <td><%= sanPham.getProductName()%></td>
                            <td><%= sanPham.getProductDescription()%></td>
                            <td><%= sanPham.getPrice()%></td>
                            <td>
                                <form action="" method="post">
                                    <input type="hidden" name="productId" value="<%= sanPham.getProductId() %>">
                                    <button type="submit" name="operation" value="xoa">Xoa</button>
                                </form>
                                <
                            </td>
                        </tr>
                        <%
                            }
                        %>


                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>