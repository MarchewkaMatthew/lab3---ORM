package org.example;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name="ADDRESS")
public class Address {
    @Column(table="ADDRESS")
    private Integer ApartmentNumber;
    @Column(table="ADDRESS")
    private Integer BlockNumber;
    @Column(table="ADDRESS")
    private String Street;
    @Column(table="ADDRESS")
    private String City;
    @Column(table="ADDRESS")
    private String ZipCode;
    @Column(table="ADDRESS")
    private String Country;

    public Address() {
    }

    public Address(Integer apartmentNumber, Integer blockNumber, String street, String city, String zipCode, String country) {
        ApartmentNumber = apartmentNumber;
        BlockNumber = blockNumber;
        Street = street;
        City = city;
        ZipCode = zipCode;
        Country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "ApartmentNumber=" + ApartmentNumber +
                ", BlockNumber=" + BlockNumber +
                ", Street='" + Street + '\'' +
                ", City='" + City + '\'' +
                ", ZipCode='" + ZipCode + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
