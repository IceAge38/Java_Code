package sit.int202.classicmodels.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;
import java.util.UUID;

// 64130500038 Thannicha
@WebServlet(name = "InsertOfficeServlet", value = "/InsertOfficeServlet")
public class InsertOfficeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Insert-Office.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Office Insertoffice = new Office();
        String officeCode = UUID.randomUUID().toString().substring(0,4);

        if(request.getParameter("city").length()!=0 || request.getParameter("country").length()!=0){


        Insertoffice.setOfficeCode(officeCode);
        Insertoffice.setAddressLine1(request.getParameter("addressLine1"));
        Insertoffice.setAddressLine2(request.getParameter("addressLine2"));
        Insertoffice.setCity(request.getParameter("city"));
        Insertoffice.setState(request.getParameter("state"));
        Insertoffice.setCountry(request.getParameter("country"));
        Insertoffice.setPostalCode(request.getParameter("postalCode"));
        Insertoffice.setPhoneNumber(request.getParameter("phoneNumber"));
        Insertoffice.setTerritory(request.getParameter("territory"));

        OfficeRepository officeRepository = new OfficeRepository();
        if (officeRepository.insert(Insertoffice)) {
            request.setAttribute("Mess", "Insert success");
            request.getRequestDispatcher("/Insert-Office.jsp").forward(request, response);
        }
    } else {
            request.setAttribute("Mess", "Insert failed");
            request.getRequestDispatcher("/Insert-Office.jsp").forward(request, response);
        }

    }

}
