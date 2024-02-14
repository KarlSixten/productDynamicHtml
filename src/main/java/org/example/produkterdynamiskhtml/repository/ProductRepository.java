package org.example.produkterdynamiskhtml.repository;

import org.example.produkterdynamiskhtml.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productlist;

    public ProductRepository() {
        populateProductList();
    }

    private void populateProductList() {
        productlist = new ArrayList<>(List.of(
                new Product(1, "Vand", 10),
                new Product(2, "Vodka", 8),
                new Product(3, "Smøger (blød pakke)", 58),
                new Product(4, "Smøger (hård pakke)", 60)));
    }

    public List<Product> getProductlist() {
        return productlist;
    }

    public void addProduct(Product productToAdd) {
        productToAdd.setId(productlist.size() + 1);
        productlist.add(productToAdd);
    }

    public void updateProduct(Product productToUpdate) {
        productlist.set(productToUpdate.getId() - 1, productToUpdate);
    }
}
