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

    @Embedded
    private Address Address;

    public Supplier(String companyName, Address address) {
        CompanyName = companyName;
        Products = new HashSet<>();
        Address = address;
    }

    public Supplier() {
    }

    public Set<Product> getProducts() {
        return Products;
    }

    public void addSupplierProduct(Product product) {
        this.Products.add(product);
    }

    public org.example.Address getAddress() {
        return Address;
    }
}
