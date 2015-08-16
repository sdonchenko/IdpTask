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
    <script type="text/javascript">

        var qvalue = "0";

        function setCookie(cname, cvalue, exmins) {
            var d = new Date();
            d.setTime(d.getTime() + (exmins * 60 * 1000));
            var expires = "expires=" + d.toGMTString();
            if (qvalue.indexOf(cvalue) >= 0) {
                qvalue = qvalue.replace("," + cvalue, "");
            } else {
                qvalue = qvalue + "," + cvalue;
            }
            document.cookie = cname + "=" + qvalue + "; " + expires;
        }

        setCookie("product", "", 1);

    </script>
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
            <td><input type="checkbox" id="p1" name="product1" value="product1"></td>
            <script>
                document.getElementById("p1").addEventListener("click", function () {
                    setCookie("product", 1, 1)
                });
            </script>
        </tr>
        <tr>
            <td>Product 2</td>
            <td><input type="checkbox" id="p2" name="product2" value="product2"></td>
            <script>document.getElementById("p2").addEventListener("click", function () {
                setCookie("product", 2, 1)
            });</script>
        </tr>
        <tr>
            <td>Product 3</td>
            <td><input type="checkbox" id="p3" name="product3" value="product3"></td>
            <script>document.getElementById("p3").addEventListener("click", function () {
                setCookie("product", 3, 1)
            });</script>
        </tr>
        <tr>
            <td>Product 4</td>
            <td><input type="checkbox" id="p4" name="product4" value="product4"></td>
            <script>document.getElementById("p4").addEventListener("click", function () {
                setCookie("product", 4, 1)
            });</script>
        </tr>
        <tr>
            <td>Product 5</td>
            <td><input type="checkbox" id="p5" name="product5" value="product5"></td>
            <script>document.getElementById("p5").addEventListener("click", function () {
                setCookie("product", 5, 1)
            });</script>
        </tr>
    </table>
    <input type="submit" value="checkout"/>
</form>
<form action="loginPage" method="get">
    <input type="submit" value="logout"/>
</form>
</body>
</html>
