package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Environment;
import sit.int202.classicmodels.entities.Office;

import javax.swing.text.html.parser.Entity;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.UNIT_NAME);
        System.out.println(emf);

        EntityManager em = emf.createEntityManager();
        // System.out.println(em);
        Office office = em.find(Office.class, "11");   //finding office No.1
        if(office != null){
            System.out.printf("%s %s %s\n",office.getCity(),office.getCountry(),office.getPhoneNumber());
        }else{
            System.out.println(">>> Office code doesn't exist !!!");
        }
// -week10
        Employee emp = em.find(Employee.class, 1002);
        if(!emp.getFirstName().equalsIgnoreCase("Somchai")){
            em.getTransaction().begin();
            emp.setFirstName("Somchai");
            em.persist(emp);
            em.getTransaction().commit();
        }
        System.out.println(emp);

        // -ลองใช้ method => persist() และ remove()
//        Office newOffice = new Office();     //สร้าง officeCode ใหม่ ที่ไม่เคยมี
//        newOffice.setOfficeCode("11");
//        newOffice.setAddressLine1(office.getAddressLine1());
//        newOffice.setAddressLine2(office.getAddressLine2());
//        newOffice.setCity("KMUTT");
//        newOffice.setCountry("Thailand");
//        newOffice.setPhoneNumber(office.getPhoneNumber());
//        newOffice.setPostalCode(office.getPostalCode());
//        newOffice.setState(office.getState());
//        newOffice.setTerritory(office.getTerritory());
//        // -เริ่ม insert ลง Database
//        em.getTransaction().begin();
////      em.persist(newOffice);
//        em.remove(office);      //.find("ไอดีที่ต้องการลบ") จากบรรทัดที่ 17 แล้วลบออก
//        em.getTransaction().commit();
//        em.close();
    }
}
