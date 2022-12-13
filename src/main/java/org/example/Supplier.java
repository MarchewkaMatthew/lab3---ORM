package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier extends Company {
    @OneToMany(mappedBy = "supplier")
    private Set<Product> Products;

    private String BankAccountNumber;

    public Supplier(String companyName, Address address, String bankAccountNumber) {
        super(companyName, address);
        Products = new HashSet<>();
        BankAccountNumber = bankAccountNumber;
    }

    public Supplier() {
    }

    public Set<Product> getProducts() {
        return Products;
    }

    public void addSupplierProduct(Product product) {
        this.Products.add(product);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                ", Name='" + this.getName() + '\'' +
                ", BankAccountNumber='" + BankAccountNumber + '\'' +
                '}';
    }
}
