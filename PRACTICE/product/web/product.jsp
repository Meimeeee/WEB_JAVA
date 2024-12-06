<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="src.productDTO"%>
<%@page import="src.productDTO"%>
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
            List<productDTO> listProduct = (List<productDTO>) request.getAttribute("listProduct");
            if (listProduct == null)
                listProduct = new ArrayList<productDTO>();
        %>
        <div id="root">
            <h1>Product List</h1>
            <div id="sanPhamControl">
                <div>
                    <h3>Add product</h3>
                    <form action="" method="post">
                        <div>
                            <label for="createProductNameInput">Product Name</label>
                            <input type="text" id="createProductNameInput" required name="productName"/>
                        </div>
                        <div>
                            <label for="createProductDescriptionInput">Description</label>
                            <textarea id="createProductDescriptionInput" required name="productDescription"></textarea>
                        </div>
                        <div>
                            <label for="createProductPriceInput">Price</label>
                            <input type="number" min="1000" id="createProductPriceInput" required name="productPrice"/>
                        </div>
                        <div>
                            <button type="submit" name="operation" value="add">Add</button>
                        </div>
                    </form>
                </div>
                <div>
                    <h3>Update product</h3>
                    <form action="" method="post">
                        <div>
                            <label for="selectProductInput">Select Product</label>
                            <select id="selectProductInput" name="productId" >

                                <%
                                    for (int i = 0; i < listProduct.size(); i++) {
                                        productDTO product = listProduct.get(i);
                                %>
                                <option value="<%= product.getProductId()%>"> <%= product.getProductName()%> </option>
                                <%
                                    }
                                %>

                            </select>
                        </div>
                        <div>
                            <label for="updateProductNameInput">Product Name</label>
                            <input type="text" id="updateProductNameInput" required name="productName"/>
                        </div>
                        <div>
                            <label for="updateProductDescriptionInput">Description</label>
                            <textarea id="updateProductDescriptionInput" required name="productDescription"></textarea>
                        </div>
                        <div>
                            <label for="updateProductPriceInput">Price</label>
                            <input type="number" min="1000" id="updateProductPriceInput" required name="productPrice"/>
                        </div>
                        <div>
                            <button type="submit" name="operation" value="update">Save</button>
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
                            <th>Product Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < listProduct.size(); i++) {
                                productDTO product = listProduct.get(i);
                        %>
                        <tr>
                            <td><%= product.getProductId()%></td>
                            <td><%= product.getProductName()%></td>
                            <td><%= product.getProductDescription()%></td>
                            <td><%= product.getProductPrice()%></td>

                            <td>
                                <form action="" method="post">
                                    <input type="hidden" name="productId" value="<%= product.getProductId() %>"/>
                                    <button type="submit" name="operation" value="delete">Delete</button>
                                </form>
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