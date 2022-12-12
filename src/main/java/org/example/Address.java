package org.example;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private Integer ApartmentNumber;
    private Integer BlockNumber;
    private String Street;
    private String City;
    private String ZipCode;
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
