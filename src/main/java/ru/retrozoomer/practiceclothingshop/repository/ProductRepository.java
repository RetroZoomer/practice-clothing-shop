package ru.retrozoomer.practiceclothingshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.retrozoomer.practiceclothingshop.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
