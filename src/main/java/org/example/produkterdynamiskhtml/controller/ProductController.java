package org.example.produkterdynamiskhtml.controller;

import org.example.produkterdynamiskhtml.model.Product;
import org.example.produkterdynamiskhtml.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String getProducts(Model model){
        List<Product> productList = productService.getProductList();
        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/update")
    public String updateProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.getProductList().get(id- 1));
        return "update";
    }

    @PostMapping("/{id}/update")
    public String updateProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/products";
    }
}
