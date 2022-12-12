package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )
    private Integer Id;
    private String ProductName;
    private Integer UnitsOnStock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="SUPPLIER_FK")
    private Supplier supplier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CATEGORY_FK")
    private Category category;

    @ManyToMany(mappedBy = "Products")
    private Set<Invoice> Invoices;

    public Set<Invoice> getInvoices() {
        return Invoices;
    }

    public void addInvoiceToProduct(Invoice invoice) {
        this.Invoices.add(invoice);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Product(String productName, Integer unitsOnStock, Supplier supplier) {
        ProductName = productName;
        UnitsOnStock = unitsOnStock;
        this.supplier = supplier;
        Invoices = new HashSet<>();
    }

    public Product(String productName, Integer unitsOnStock) {
        ProductName = productName;
        UnitsOnStock = unitsOnStock;
        Invoices = new HashSet<>();
    }

    public Product() {}

    @Override
    public String toString() {
        return "Product{" +
                "ProductName='" + ProductName + '\'' +
                ", UnitsOnStock=" + UnitsOnStock +
                ", supplier=" + supplier +
                ", category=" + category +
                '}';
    }
}
