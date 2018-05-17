package by.itacademy.servlet;

import by.itacademy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", UserService.getInstance().getUser(1L));
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/greeting.jsp")
                .forward(req, resp);
    }
}
