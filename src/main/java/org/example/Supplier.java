package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
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
    private String Street;
    private String City;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Product> Products;

    public Set<Product> getProducts() {
        return Products;
    }

    public void addSupplierProduct(Product product) {
        this.Products.add(product);
    }

    public Supplier(String companyName, String street, String city) {
        CompanyName = companyName;
        Street = street;
        City = city;
        Products = new HashSet<>();
    }

    public Supplier() {
    }
}
