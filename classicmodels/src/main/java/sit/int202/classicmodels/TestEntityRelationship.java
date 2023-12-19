package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Envionment;
import sit.int202.classicmodels.entities.Office;

import java.util.List;

public class TestEntityRelationship {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Envionment.UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        List<Office> officeList =  em.createNamedQuery("OFFICE.FIND_ALL").getResultList(); //ไปดึงข้อมูลมา
        for (Office office : officeList) {
            System.out.printf("(%s) %s %s %s\n",   // % บอกระยะห่างช่องว่างคอลัมน์ เมื่อนำมาแสดง
                    office.getOfficeCode(),office.getAddressLine1(),
                    office.getCity(),office.getCountry());
            System.out.println("---------------------------------");
            for (Employee employee : office.getEmployeeList()) {
                System.out.printf("%8d %-10s %-12s %-20s\n",   // % บอกระยะห่างช่องว่างคอลัมน์ เมื่อนำมาแสดง
                        employee.getId(),employee.getFirstName(),
                        employee.getLastName(),employee.getJobTitle());
            }
            System.out.println("\n\n");
        }
        em.close();
    }
}
