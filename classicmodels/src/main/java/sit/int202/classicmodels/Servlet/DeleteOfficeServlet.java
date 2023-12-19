package sit.int202.classicmodels.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;

// 64130500038 Thannicha
@WebServlet(name = "DeleteOfficeServlet", value = "/DeleteOfficeServlet")
public class DeleteOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Delete-Office.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String officeCode = request.getParameter("officeCode");
        OfficeRepository officeRepository = new OfficeRepository();
        if (officeRepository.delete(officeCode)){
            getServletContext().getRequestDispatcher("/Delete-Office.jsp").forward(request, response);
        }
    }
}
