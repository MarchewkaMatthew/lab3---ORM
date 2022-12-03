package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
//        Supplier supplier = new Supplier("AGH", "Nawojki", "Kraków");
//
//        Product product = session.get(org.example.Product.class, 1);
//        product.setSupplier(supplier);

        Supplier supplier = session.get(org.example.Supplier.class, 1);

        Product product = new Product("Stolik", 10, supplier);

        try {
            Transaction tx = session.beginTransaction();
            session.save(product);
//            session.save(supplier);
//            session.update(product);
            tx.commit();
        } finally {
            session.close();
        }
    }
}
