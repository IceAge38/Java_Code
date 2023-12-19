package sit.int202.classicmodels.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Office;

import java.util.List;

public class OfficeRepository {
    private EntityManager entityManager;    //สร้างแล้วเก็บไว้ที่นี่

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
         return entityManager;
    }

    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("OFFICE.FIND_ALL").getResultList();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public void close() {   //ปิดการใช้งาน entity manager
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    //Create => insert
    public boolean insert(Office office) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

    //Delete by Code
    public boolean delete(String officeCode) {
                EntityManager entityManager = getEntityManager();
        Office office = find(officeCode);
        if (office != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(office);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    //All Delete
//    public boolean delete(Office office) {
//        if (office != null) {
//            EntityManager entityManager = getEntityManager();
//            if (entityManager.contains(office)) {
//                entityManager.getTransaction().begin();
//                entityManager.remove(office);
//                entityManager.getTransaction().commit();
//                return true;
//            } else {
//                return delete(office.getOfficeCode());
//            }
//        }
//        return false;
//    }

    //Update
    public boolean update(Office newOffice) {
        if (newOffice != null) {
            EntityManager entityManager = getEntityManager();
            Office office = find(newOffice.getOfficeCode());
            if (office != null) {
                try {
                entityManager.getTransaction().begin();
                //set all attributes office with newOffice
                office.setOfficeCode(newOffice.getOfficeCode());
                office.setAddressLine1(newOffice.getAddressLine1());
                office.setAddressLine2(newOffice.getAddressLine2());
                office.setCity(newOffice.getCity());
                office.setState(newOffice.getState());
                office.setCountry(newOffice.getCountry());
                office.setPostalCode(newOffice.getPostalCode());
                office.setPhoneNumber(newOffice.getPhoneNumber());
                office.setTerritory(newOffice.getTerritory());
                 entityManager.getTransaction().commit();
                 return true;
            } catch (Exception e) {
                    e.printStackTrace();  // หรือ log ลง log file
                    entityManager.getTransaction().rollback();  // ถ้าเกิดข้อผิดพลาดในระหว่างการ commit
                }
            }
        }
        return false;
    }


    public List<Office> findByCityOrCountry(String cityOrCountry) {    //  ค้นหา field city or country
        cityOrCountry = cityOrCountry.toLowerCase() + '%';
        Query query = getEntityManager().createNamedQuery("OFFICE.FIND_BY_CITY_OR_COUNTRY");
        query.setParameter("city", cityOrCountry);
        query.setParameter("country", cityOrCountry);
        return query.getResultList();}

}
