package ru.retrozoomer.practiceclothingshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "\"product\"")
public class ProductShowcase {
    @Id
    private Long id;
    private String name;
    private String description;
    private double price;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Size> sizes;
    @ManyToMany(mappedBy = "products")
    private Set<User> users;
}
