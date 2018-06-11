package by.itacademy.servlet;

import by.itacademy.service.interfaces.BookService;
import by.itacademy.util.ContextUtil;
import org.springframework.data.domain.PageRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", ContextUtil.getBean(BookService.class).findAllBy(PageRequest.of(0, 2)));
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/booking.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer numberPage = Integer.valueOf(req.getParameter("numberPage"));
        Integer size = Integer.valueOf(req.getParameter("limit"));
        req.setAttribute("books", ContextUtil.getBean(BookService.class).findAllBy(PageRequest.of(numberPage - 1, size)));
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/booking.jsp")
                .forward(req, resp);
    }
}
