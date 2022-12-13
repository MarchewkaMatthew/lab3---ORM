package org.example;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Company {
    @Id
    @SequenceGenerator(
            name = "company_id_sequence",
            sequenceName = "company_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_id_sequence"
    )
    private Integer Id;
    private String Name;

    @Embedded
    private Address Address;

    public Company() {
    }

    public Company(String name, org.example.Address address) {
        Name = name;
        Address = address;
    }

    public org.example.Address getAddress() {
        return Address;
    }

    public String getName() {
        return Name;
    }
}
