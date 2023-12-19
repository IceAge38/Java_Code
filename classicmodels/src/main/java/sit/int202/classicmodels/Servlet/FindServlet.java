package sit.int202.classicmodels.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;
// 64130500038 Thannicha
@WebServlet(name = "FindServlet", value = "/FindServlet")
public class FindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("offices", officeRepository.findAll());
        getServletContext().getRequestDispatcher("/Find-Office.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityOrCountry = request.getParameter("cityOrCountry");
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("FindByCityCountry", officeRepository.findByCityOrCountry(cityOrCountry));
        request.getRequestDispatcher("/Find-Office.jsp").forward(request, response);

    }
}
