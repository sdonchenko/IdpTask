package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sergii on 23.07.2015.
 */
@WebServlet("/productPage")
public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null
                && "sergii".equals(session.getAttribute("name"))
                && "sdonch$2015".equals(session.getAttribute("password"))) {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE HTML>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<title>Order page</title>\n" +
                    "</head>\n" +
                    "<script type=\"text/javascript\">" +
                    "function getCookie(cname) {\n" +
                    "    var name = cname + \"=\";\n" +
                    "    var ca = document.cookie.split(';');\n" +
                    "    for(var i=0; i<ca.length; i++) {\n" +
                    "        var c = ca[i];\n" +
                    "        while (c.charAt(0)==' ') c = c.substring(1);\n" +
                    "        if (c.indexOf(name) == 0) {\n" +
                    "           var str = c.substring(name.length, c.length);\n" +
                    "           var arr = str.split(\",\");\n" +
                    "           arr.sort();\n" +
                    "           for (var i=1; i<arr.length; i++) {\n" +
                    "               document.write(\"- Product \" + arr[i] + \"<br />\");\n" +
                    "           }\n" +
                    "        }\n" +
                    "    }\n" +
                    "    return \"\";\n" +
                    "}" +
                    "</script>\n" +
                    "<body>\n" +
                    "<b>Order Confirmation:</b><br />" +
                    "<script>" +
                    "getCookie(\"product\")" +
                    "</script>\n" +
                    " <br/><br/>" +
                    "<form action=\"loginPage\" method=\"get\">\n" +
                    "   <input type=\"submit\" value=\"logout\"/>\n" +
                    "</form>" +
                    "</body>\n" +
                    "</html>");
        } else {
            response.sendRedirect("/loginPage.jsp");
        }
    }
}