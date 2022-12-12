package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@SecondaryTable(name="ADDRESS")
public class Supplier {
    @Id
    @SequenceGenerator(
            name = "supplier_id_sequence",
            sequenceName = "supplier_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "supplier_id_sequence"
    )
    private Integer Id;
    private String CompanyName;

    @OneToMany(mappedBy = "supplier")
    private Set<Product> Products;

    @Column(table = "ADDRESS")
    private Integer ApartmentNumber;
    @Column(table = "ADDRESS")
    private Integer BlockNumber;
    @Column(table = "ADDRESS")
    private String Street;
    @Column(table = "ADDRESS")
    private String City;
    @Column(table = "ADDRESS")
    private String ZipCode;
    @Column(table = "ADDRESS")
    private String Country;

    public Supplier(String companyName) {
        CompanyName = companyName;
        Products = new HashSet<>();
    }

    public Supplier() {
    }

    public Set<Product> getProducts() {
        return Products;
    }

    public void addSupplierProduct(Product product) {
        this.Products.add(product);
    }
}
