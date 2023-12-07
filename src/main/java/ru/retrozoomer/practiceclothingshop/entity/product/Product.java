package ru.retrozoomer.practiceclothingshop.entity.product;

import lombok.Data;
import ru.retrozoomer.practiceclothingshop.entity.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "\"product\"")
public class Product {
    @Id
    private Long id;

    private String name;

    private String image;

    @Enumerated(EnumType.STRING)
    private ECategory category;

    @Enumerated(EnumType.STRING)
    private Egender gender;

    private String description;

    private double price;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Size> sizes;

    @ManyToMany(mappedBy = "products")
    private Set<User> users;
}
