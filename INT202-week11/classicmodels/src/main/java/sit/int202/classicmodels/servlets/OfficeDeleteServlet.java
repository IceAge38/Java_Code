package sit.int202.classicmodels.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeDeleteServlet", value = "/officeDelete")
public class OfficeDeleteServlet extends HttpServlet {
    private OfficeRepository officeRepository = new OfficeRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ดึงค่า officeCode จาก URL Parameter
        String officeCode = request.getParameter("officeCode");
        request.setAttribute("deletedOfficeCode", officeCode);

        // ตรวจสอบว่า officeCode ไม่เป็น null และไม่ว่างเปล่า
        if (officeCode != null && !officeCode.isEmpty()) {
            // เรียก Repository หรือ Service ที่มีเมธอด delete และส่ง officeCode ไป
            boolean isSuccess = officeRepository.delete(officeCode);
            request.setAttribute("isDeleteSuccess", isSuccess);
            // ตรวจสอบว่าลบสำเร็จหรือไม่
            if (isSuccess) {
                // ถ้าลบสำเร็จ, redirect ไปยังหน้าที่ต้องการ
                getServletContext().getRequestDispatcher("/office_delete.jsp").forward(request, response);
            } else {
                // ถ้าลบไม่สำเร็จ, สามารถทำการ forward หรือ redirect ไปยังหน้าที่ต้องการแจ้งเตือนผู้ใช้
                request.setAttribute("errorMessage", "Failed to delete office.");
                request.getRequestDispatcher("office_delete.jsp").forward(request, response);
            }
        } else {
            // ถ้าไม่มี officeCode ใน URL Parameter, สามารถทำการ forward หรือ redirect ไปยังหน้าที่ต้องการ
            request.getRequestDispatcher("office_delete.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
