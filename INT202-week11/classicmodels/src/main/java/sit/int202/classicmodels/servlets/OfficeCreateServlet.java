package sit.int202.classicmodels.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeCreateServlet", value = "/officeCreate")
public class OfficeCreateServlet extends HttpServlet {
    private OfficeRepository officeRepository = new OfficeRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // รับข้อมูลจากแบบฟอร์ม
            String officeCode = request.getParameter("officeCode");
            String addressLine1 = request.getParameter("addressLine1");
            String addressLine2 = request.getParameter("addressLine2");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String country = request.getParameter("country");
            String postalCode = request.getParameter("postalCode");
            String phoneNumber = request.getParameter("phoneNumber");
            String territory = request.getParameter("territory");

            // สร้าง Object Product จากข้อมูลที่รับมา
            Office newOffice = new Office();
            newOffice.setOfficeCode(officeCode);
            newOffice.setAddressLine1(addressLine1);
            newOffice.setAddressLine2(addressLine2);
            newOffice.setCity(city);
            newOffice.setState(state);
            newOffice.setCountry(country);
            newOffice.setPostalCode(postalCode);
            newOffice.setPhoneNumber(phoneNumber);
            newOffice.setTerritory(territory);

            // เรียกใช้ method insert ใน OfficeRepository
            boolean isSuccess = officeRepository.insert(newOffice);

            if (isSuccess) {
                // ถ้า insert สำเร็จ ให้ redirect ไปยังหน้าที่ต้องการ
                getServletContext().getRequestDispatcher("/office_create.jsp").forward(request, response);

            } else {
                // ถ้าไม่สำเร็จ ให้ตั้งค่าข้อความผลลัพธ์และนำไปแสดงในหน้าที่เหมาะสม
                request.setAttribute("errorMessage", "Failed to create office.");
                request.getRequestDispatcher("/office_create.jsp").forward(request, response);
            }

        } catch (Exception e) {
            // ตัวจัดการข้อผิดพลาดที่เหมาะสม
            e.printStackTrace();  // หรือ log ลง log file
            request.setAttribute("errorMessage", "Not have Message");
            request.getRequestDispatcher("/office_create.jsp").forward(request, response);
        }
    }
}

