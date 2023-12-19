package sit.int202.classicmodels.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;
import java.util.UUID;

// 64130500038 Thannicha
@WebServlet(name = "UpdateOfficeServlet", value = "/UpdateOfficeServlet")
public class UpdateOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("offices", officeRepository.findAll());
        String officeCode = request.getParameter("officeCode");
        if (officeCode != null){
            request.setAttribute("selectedOffice" , officeRepository.find(officeCode));
        }
        request.getRequestDispatcher("/Update-Office.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Office newOffice = new Office();
        newOffice.setOfficeCode(request.getParameter("officeCode"));
        newOffice.setAddressLine1(request.getParameter("addressLine1"));
        newOffice.setAddressLine2(request.getParameter("addressLine2"));
        newOffice.setCity(request.getParameter("city"));
        newOffice.setState(request.getParameter("state"));
        newOffice.setCountry(request.getParameter("country"));
        newOffice.setPostalCode(request.getParameter("postalCode"));
        newOffice.setPhoneNumber(request.getParameter("phoneNumber"));
        newOffice.setTerritory(request.getParameter("territory"));
        OfficeRepository officeRepository = new OfficeRepository();
        if (officeRepository.update(newOffice)) {
            request.setAttribute("offices", officeRepository.findAll());
            request.getRequestDispatcher("/Update-Office.jsp").forward(request, response);
        }else {
            request.setAttribute("errorMess", "Update failed");
        }

    }
}
