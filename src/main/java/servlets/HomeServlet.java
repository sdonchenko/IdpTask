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

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if ("sergii".equals(request.getParameter("name")) && "sdonch$2015".equals(request.getParameter("password"))) {

            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setMaxInactiveInterval(100);

            request.getRequestDispatcher("/productPage.jsp").forward(request, response);

        } else {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
        }
    }
}