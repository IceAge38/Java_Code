package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Environment;
import sit.int202.classicmodels.entities.Office;

import java.util.List;
import java.util.Scanner;

public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.UNIT_NAME);
        System.out.println(emf);

        EntityManager em = emf.createEntityManager();
//      Query query = em.createNamedQuery("OFFICE.FIND_ALL");  // 1.
        Query query = em.createNamedQuery("OFFICE.FIND_BY_COUNTRY"); // 2.
        System.out.println("Find office by country start with: ");
        String country = new Scanner(System.in).next();       // ขึ้นต้นตัวอักษรที่พิมพ์ ตามหลังด้วยอะไรก็ได้ "%"
        query.setParameter("countryParam", country + "%");   // หากใช้ query ที่มี parameter ต้อง setParameter ก่อนไปสั่ง .getResultList()

        List<Office> offices = query.getResultList();
        for (Office office : offices) {
            System.out.printf("%-4s %-25s %-15s %-12s\n",   // % บอกระยะห่างช่องว่างคอลัมน์ เมื่อนำมาแสดง
                    office.getOfficeCode(),office.getAddressLine1(),
                    office.getCity(),office.getCountry());
        }
        System.out.println("-------------------");
        List<Employee> employees = em.createNamedQuery("EMPLOYEE.FIND_ALL").getResultList();
        for (Employee employee : employees) {
            System.out.printf("%-4s %-25s %-15s %-12s \n",   // % บอกระยะห่างช่องว่างคอลัมน์ เมื่อนำมาแสดง
                    employee.getEmployeeNumber(),employee.getFirstName(),
                    employee.getLastName(),employee.getJobTitle());
        }
        em.close();
    }
}
