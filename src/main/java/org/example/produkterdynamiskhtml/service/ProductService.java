package org.example.produkterdynamiskhtml.service;

import org.example.produkterdynamiskhtml.model.Product;
import org.example.produkterdynamiskhtml.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        return productRepository.getProductlist();
    }

    public void addProduct(Product productToAdd) {
        productRepository.addProduct(productToAdd);
    }

    public void updateProduct(Product productToUpdate) {
        productRepository.updateProduct(productToUpdate);
    }
}
