package ru.retrozoomer.practiceclothingshop.entity.product;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "\"product\"")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    @Enumerated(EnumType.STRING)
    private ECategory category;

    private String description;

    private double price;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Size> sizes;

}
