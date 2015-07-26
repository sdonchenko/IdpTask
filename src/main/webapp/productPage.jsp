<%--
  Created by IntelliJ IDEA.
  User: Sergii
  Date: 19.07.2015
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Product page</title>
    </head>
    <body>
        <form action="productPage" method="get">
            <table>
                <tr>
                    <th>Product</th>
                    <th>Buy</th>
                </tr>
                <tr>
                    <td>Product 1</td>
                    <td><input type="checkbox" name="product1" value="product1"></td>
                </tr>
                <tr>
                    <td>Product 2</td>
                    <td><input type="checkbox" name="product2" value="product2"></td>
                </tr>
                <tr>
                    <td>Product 3</td>
                    <td><input type="checkbox" name="product3" value="product3"></td>
                </tr>
                <tr>
                    <td>Product 4</td>
                    <td><input type="checkbox" name="product4" value="product4"></td>
                </tr>
                <tr>
                    <td>Product 5</td>
                    <td><input type="checkbox" name="product5" value="product5"></td>
                </tr>
            </table>
            <input type="submit" value="checkout"/>
        </form>
        <form action="loginPage" method="get">
            <input type="submit" value="logout"/>
        </form>
    </body>
</html>
