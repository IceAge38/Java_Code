package sit.int202.classicmodels.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Product;
import sit.int202.classicmodels.models.Cart;
import sit.int202.classicmodels.models.ClassicModelLineItem;
import sit.int202.classicmodels.repositories.ProductRepository;

import java.io.IOException;

@WebServlet(name = "AddToCartServlet", value = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        //vvv เพิ่มสินค้าทุกครั้ง เก็บเป็น session
        HttpSession session = request.getSession();   //เก็บเป็น session: ถ้าไม่มี -> ให้สร้าง, ถ้ามี -> ใช้ตัวเดิม
        Cart<String, ClassicModelLineItem> cart = (Cart) session.getAttribute("cart"); //ไปถามว่าใน session มีตะกร้าหรือยัง
        if (cart == null) {                          //ถ้าไม่มีตะกร้า คือ เพิ่มครั้งแรก = สร้าง obj ของตะกร้า
            cart = new Cart<>();
            session.setAttribute("cart", cart);   //แล้วเก็บไว้ที่ session
        }
        ProductRepository productRepository = new ProductRepository();  //สร้าง repo เพื่อไปค้นหา product
        Product product = productRepository.findProduct(productCode);   //นำ productCode ไปค้นหา
        if (product != null) {
            cart.addItem(productCode, new ClassicModelLineItem(product)); //เพิ่ม 1 ชิ้น
        }
        response.getWriter().print(cart.getNoOfItem());   //ส่งเป็ฯจำนวนรายการ คือ getNoOfItem() method
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
