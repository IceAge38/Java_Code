package sit.int202.classicmodels.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OfficeSearchServlet", value = "/search")
public class OfficeSearchServlet extends HttpServlet {
    private OfficeRepository officeRepository = new OfficeRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // รับค่า searchQuery จาก request URL
        String searchQuery = request.getParameter("searchQuery");

        // เช็คว่าค่าที่รับมาเป็น city หรือ country แล้วดำเนินการค้นหาตามที่ต้องการ
        if (searchQuery != null && !searchQuery.isEmpty()) {
            // เรียกใช้ repository เพื่อค้นหา
            List<Office> offices = officeRepository.findByCityOrCountry(searchQuery);
            // นำข้อมูล offices ไปใช้ต่อ (ตัวอย่างเช่น นำไป set ใน request เพื่อแสดงในหน้า JSP)
            request.setAttribute("offices", offices);
        }

        // ทำการ Forward ไปยังหน้า JSP ที่แสดงผลลัพธ์ค้นหา
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search_result.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
