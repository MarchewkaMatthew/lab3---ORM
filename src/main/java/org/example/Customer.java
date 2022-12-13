package org.example;

import javax.persistence.Entity;
import javax.persistence.SecondaryTable;

@Entity
public class Customer extends Company {
    private Integer Discount;

    public Customer() {
    }

    public Customer(String name, org.example.Address address, Integer discount) {
        super(name, address);
        Discount = discount;
    }

    public Integer getDiscount() {
        return Discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", Name='" + this.getName() + '\'' +
                "Discount=" + Discount +
                '}';
    }
}

