package ru.retrozoomer.practiceclothingshop.entity.product;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "\"size\"")
public class Size {
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private EFit fit;

    private int count;

    @ManyToMany(mappedBy = "sizes")
    private Set<Product> products;
}
