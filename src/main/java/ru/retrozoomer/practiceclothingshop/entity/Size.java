package ru.retrozoomer.practiceclothingshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Data
@Table(name = "\"size\"")
public class Size {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private EFit EFit;
    @ManyToMany(mappedBy = "sizes")
    private Set<ProductShowcase> productShowcases;
}
