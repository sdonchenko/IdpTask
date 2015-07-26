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

        String name = "";
        String password = "";

        HttpSession session = request.getSession(false);
        if (session != null) {
            name = (String) session.getAttribute("name");
            password = (String) session.getAttribute("password");
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        String orderList = "";

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().contains("product") && request.getParameter(cookie.getName()) != null) {
                cookie.setValue("- Ordered " + cookie.getName());
                orderList += "<br/>" + cookie.getValue() + ";";
            }
        }

        out.println("<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Order page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<b>Order Confirmation:</b>" +
                orderList.substring(0, orderList.length() - 1) + ". <br/><br/>" +
                "Your login: " + name +  " & password: " + password + " (it is from session)" +
                "<form action=\"loginPage\" method=\"get\">\n" +
                "   <input type=\"submit\" value=\"logout\"/>\n" +
                "</form>" +
                "</body>\n" +
                "</html>");
    }
}