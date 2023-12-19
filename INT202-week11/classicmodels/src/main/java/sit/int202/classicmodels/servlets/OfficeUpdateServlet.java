package sit.int202.classicmodels.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeUpdateServlet", value = "/officeUpdate")
public class OfficeUpdateServlet extends HttpServlet {
    private OfficeRepository officeRepository = new OfficeRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //ทดลอง
        String officeCode = request.getParameter("officeCode");
        Office existingOffice = officeRepository.find(officeCode);
        request.setAttribute("existingOffice", existingOffice);
        request.getRequestDispatcher("/office_update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // รับข้อมูลที่ต้องการแก้ไขจาก Form
        String officeCode = request.getParameter("officeCode");
        String addressLine1 = request.getParameter("addressLine1");
        String addressLine2 = request.getParameter("addressLine2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String postalCode = request.getParameter("postalCode");
        String phoneNumber = request.getParameter("phoneNumber");
        String territory = request.getParameter("territory");

        // เรียกใช้ Repository เพื่อดึงข้อมูลเดิม
        Office existingOffice = officeRepository.find(officeCode);

        if (existingOffice != null) {
            // อัปเดตข้อมูลใน Repository
            existingOffice.setOfficeCode(officeCode);
            existingOffice.setAddressLine1(addressLine1);
            existingOffice.setAddressLine2(addressLine2);
            existingOffice.setCity(city);
            existingOffice.setState(state);
            existingOffice.setCountry(country);
            existingOffice.setPostalCode(postalCode);
            existingOffice.setPhoneNumber(phoneNumber);
            existingOffice.setTerritory(territory);
            request.setAttribute("existingOffice", existingOffice);
            // ทำการ Forward ไปยังหน้า JSP
            request.getRequestDispatcher("/office_update.jsp").forward(request, response);

        } else {
            // ถ้าไม่พบข้อมูลเดิม, สามารถตั้งค่าข้อความผลลัพธ์และนำไปแสดงในหน้าที่เหมาะสม
            request.setAttribute("errorMessage", "Office not found.");
            request.getRequestDispatcher("/office_update.jsp").forward(request, response);
        }

        boolean isSuccess = officeRepository.update(existingOffice);

        if (isSuccess) {
            // ทำการ Redirect หรือ Forward ไปยังหน้าที่ต้องการ
            response.sendRedirect("/office_update.jsp");
        } else {
            // ถ้าไม่สำเร็จ, สามารถตั้งค่าข้อความผลลัพธ์และนำไปแสดงในหน้าที่เหมาะสม
            request.setAttribute("errorMessage", "Failed to update office.");
            request.getRequestDispatcher("/office_update.jsp").forward(request, response);
        }
    }
}
