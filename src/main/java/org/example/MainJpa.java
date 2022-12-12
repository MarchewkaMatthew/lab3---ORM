package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainJpa {
    public static void main(final String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();

        // VI

//        Product product1 = new Product("Koszulka", 10);
//        Product product2 = new Product("Bluza", 15);
//        Product product3 = new Product("Skarpetki", 20);
//        em.persist(product1);
//        em.persist(product2);
//        em.persist(product3);
//
//        Invoice invoice1 = new Invoice(403);
//        Invoice invoice2 = new Invoice(427);
//        em.persist(invoice1);
//        em.persist(invoice2);
//
//        invoice1.addProductToInvoice(product1);
//        invoice1.addProductToInvoice(product2);
//        invoice1.addProductToInvoice(product3);
//
//        invoice2.addProductToInvoice(product1);

        Invoice foundInvoice = em.find(org.example.Invoice.class, 1);
        System.out.println(foundInvoice.getProducts());

        Product foundProduct  = em.find(org.example.Product.class, 1);
        System.out.println(foundProduct.getInvoices());

        etx.commit();
        em.close();
    }
}