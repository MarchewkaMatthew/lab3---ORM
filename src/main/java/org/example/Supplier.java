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
    @AttributeOverrides({
            @AttributeOverride(name="ApartmentNumber", column=@Column(table="ADDRESS")),
            @AttributeOverride(name="BlockNumber", column=@Column(table="ADDRESS")),
            @AttributeOverride(name="Street", column=@Column(table="ADDRESS")),
            @AttributeOverride(name="City", column=@Column(table="ADDRESS")),
            @AttributeOverride(name="ZipCode", column=@Column(table="ADDRESS")),
            @AttributeOverride(name="Country", column=@Column(table="ADDRESS")),
    })
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
