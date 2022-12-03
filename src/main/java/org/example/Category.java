package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_id_sequence",
            sequenceName = "category_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_id_sequence"
    )
    private Integer Id;
    private String Name;

    @OneToMany(mappedBy = "category")
    private Set<Product> Products;

    public void addCategoryProduct(Product product) {
        this.Products.add(product);
        product.setCategory(this);
    }

    public Set<Product> getProducts() {
        return Products;
    }

    public Category(String name) {
        Name = name;
        Products = new HashSet<>();
    }

    public Category() {}
}
