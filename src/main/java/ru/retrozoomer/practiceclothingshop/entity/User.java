package ru.retrozoomer.practiceclothingshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
}
