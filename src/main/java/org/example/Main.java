package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        Transaction tx = session.beginTransaction();
//        Supplier supplier = new Supplier("AGH", "Nawojki", "Kraków");
//
//        Product product = session.get(org.example.Product.class, 1);
//        product.setSupplier(supplier);

//        Supplier supplier = session.get(org.example.Supplier.class, 1);
//        Product product = new Product("Stolik", 10, supplier);

//        Product product1 = new Product("Komputer", 10);
//        Product product2 = new Product("Myszka", 15);
//        Product product3 = new Product("Klawiatura", 20);
//        session.save(product1);
//        session.save(product2);
//        session.save(product3);
//
//       Supplier supplier = new Supplier("Dell", "Ruczaj", "Katowice");
//       session.save(supplier);
//
//       supplier.addSupplierProduct(product1);
//       supplier.addSupplierProduct(product2);
//       supplier.addSupplierProduct(product3);

//        Supplier supplier = session.get(org.example.Supplier.class, 152);
//        System.out.println(supplier.getProducts().size());

        // IV

        Product product1 = new Product("Komputer", 10);
        Product product2 = new Product("Myszka", 15);
        Product product3 = new Product("Klawiatura", 20);
        session.save(product1);
        session.save(product2);
        session.save(product3);

       Supplier supplier = new Supplier("Dell", "Ruczaj", "Katowice");
       session.save(supplier);

        supplier.addSupplierProduct(product1);
        supplier.addSupplierProduct(product2);
        supplier.addSupplierProduct(product3);

        // musimy zadbać o dwustronną referencję
        product1.setSupplier(supplier);
        product2.setSupplier(supplier);
        product3.setSupplier(supplier);

        try {
            tx.commit();
        } finally {
            session.close();
        }
    }
}
