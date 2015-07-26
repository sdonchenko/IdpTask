package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginPage")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 4234153507302952345L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        Cookie product1 = new Cookie("product1", null);
        Cookie product2 = new Cookie("product2", null);
        Cookie product3 = new Cookie("product3", null);
        Cookie product4 = new Cookie("product4", null);
        Cookie product5 = new Cookie("product5", null);

        product1.setMaxAge(100);
        product2.setMaxAge(100);
        product3.setMaxAge(100);
        product4.setMaxAge(100);
        product5.setMaxAge(100);

        response.addCookie(product1);
        response.addCookie(product2);
        response.addCookie(product3);
        response.addCookie(product4);
        response.addCookie(product5);

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if ("sergii".equals(request.getParameter("name")) && "sdonch$2015".equals(request.getParameter("password"))) {

            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setMaxInactiveInterval(100);

            request.getRequestDispatcher("/productPage.jsp").forward(request, response);
        } else {


            //invalidate the session if exists
            HttpSession session = request.getSession(false);
            if(session != null){
                session.invalidate();
            }


            request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
        }
    }
}