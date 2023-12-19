package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Envionment;

import java.util.List;
import java.util.Scanner;

public class TestPaging {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Envionment.UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("EMPLOYEE.FIND_ALL");   //ไปดึงข้อมูลมา
        int start = 0;
        int pageSize = 5;
        query.setMaxResults(pageSize);       //จำนวน record มากที่สุดที่จะดึงมาในแต่ละครั้ง
        while (true){
            query.setFirstResult(start);
            // วนไป get มาที่ละ Page
            List<Employee> employees = query.getResultList();
            if(employees.isEmpty()){
                break;
            }
            start = start + pageSize;        // เพิ่มไปเอา record ต่อไปมา
            displayEmployees(employees);     //ถ้าข้อมูลยังไม่หมด ก็เรียก method มาใช้งาน
            System.out.print("Press ENTER to view next page ... ");
            new Scanner(System.in).next();
        }
        em.close();
    }
    private static void displayEmployees(List<Employee> employees){
        for (Employee employee : employees) {
            System.out.printf("%-4s %-25s %-15s %-12s\n",   // % บอกระยะห่างช่องว่างคอลัมน์ เมื่อนำมาแสดง
                    employee.getOfficeCode(),employee.getFirstName(),
                    employee.getLastName(),employee.getJobTitle());
        }
        System.out.println("--------------------------");
    }
}
