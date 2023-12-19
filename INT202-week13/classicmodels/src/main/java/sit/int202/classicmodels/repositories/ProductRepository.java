package sit.int202.classicmodels.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.entities.Product;

import java.util.List;


public class ProductRepository {
    private EntityManager entityManager;    //สร้างแล้วเก็บไว้ที่นี่
    private static int PAGE_SIZE = 10;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }
    public List<Product> findAll() {
        return getEntityManager().createNamedQuery("PRODUCT.FIND_ALL").getResultList();
    }

    public Product findProduct(String productCode) {
        return getEntityManager().find(Product.class, productCode);
    }

    public void close() {   //ปิดการใช้งาน entity manager
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }



    public int getDefaultPageSize() {
        return PAGE_SIZE;
    }

    public List<Product> findAll(int page, int pageSize) {    //นับจำนวนแถวทั้งหมด
        int startPosition = (page - 1) * pageSize;
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("PRODUCT.FIND_ALL");
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        List<Product> productList = query.getResultList();
        return productList;
    }

    public int countAll() {
        EntityManager entityManager = getEntityManager();
        int number = ((Number) entityManager.createNamedQuery("PRODUCT.COUNT").getSingleResult()).intValue();
        return number;
    }




    //Create => insert
    public boolean insert(Product product) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //All Delete
    public boolean delete(Product product) {
        if (product != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(product)) {
                entityManager.getTransaction().begin();
                entityManager.remove(product);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(product.getProductCode());
            }
        }
        return false;
    }
    //Delete by Code
    public boolean delete(String getProductCode) {
        EntityManager entityManager = getEntityManager();
        Product product = findProduct(getProductCode);
        if (product != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

//    //Update
    public boolean update(Product newProduct) {
        if (newProduct != null) {
            EntityManager entityManager = getEntityManager();
            Product product = findProduct(newProduct.getProductCode());
            if (product != null) {
                entityManager.getTransaction().begin();
                //set all attributes office with newOffice
                entityManager.getTransaction().commit();
                return true;
            }
        }        return false;
    }
}
