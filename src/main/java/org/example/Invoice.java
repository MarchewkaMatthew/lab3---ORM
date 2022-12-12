package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Invoice {
    @Id
    @SequenceGenerator(
            name = "invoice_id_sequence",
            sequenceName = "invoice_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invoice_id_sequence"
    )
    private Integer Id;
    private Integer InvoiceNumber;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Product> Products;

    public void addProductToInvoice(Product product) {
        this.Products.add(product);
        product.addInvoiceToProduct(this);
    }

    public Set<Product> getProducts() {
        return Products;
    }

    public Invoice(Integer invoiceNumber) {
        InvoiceNumber = invoiceNumber;
        Products = new HashSet<>();
    }
    public Invoice() {}

    @Override
    public String toString() {
        return "Invoice{" +
                "Id=" + Id +
                ", InvoiceNumber=" + InvoiceNumber +
                '}';
    }
}
