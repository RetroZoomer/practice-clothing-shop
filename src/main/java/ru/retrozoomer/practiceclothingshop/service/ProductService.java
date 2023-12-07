package ru.retrozoomer.practiceclothingshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.retrozoomer.practiceclothingshop.entity.product.Product;
import ru.retrozoomer.practiceclothingshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product findProductById(Long ProductId) {
        Optional<Product> productFromDb = productRepository.findById(ProductId);
        return productFromDb.orElse(new Product());
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
