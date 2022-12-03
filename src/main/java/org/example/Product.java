package org.example;

import javax.persistence.*;

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

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Product(String productName, Integer unitsOnStock, Supplier supplier) {
        ProductName = productName;
        UnitsOnStock = unitsOnStock;
        this.supplier = supplier;
    }

    public Product(String productName, Integer unitsOnStock) {
        ProductName = productName;
        UnitsOnStock = unitsOnStock;
    }

    public Product() {}
}
