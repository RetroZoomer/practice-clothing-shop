package ru.retrozoomer.practiceclothingshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.retrozoomer.practiceclothingshop.entity.product.Product;
import ru.retrozoomer.practiceclothingshop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    public Product updateProduct(Product product) {
        Optional<Product> productDB = productRepository.findById(product.getId());
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getRandomProducts() {
        List<Product> productsFromDB = productRepository.findAll();
        int pCount = productsFromDB.size();
        Random r = new Random();
        List<Product> randomProducts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomId = r.nextInt(pCount);
            randomProducts.add(productsFromDB.get(randomId));
        }
        return randomProducts;
    }
}
