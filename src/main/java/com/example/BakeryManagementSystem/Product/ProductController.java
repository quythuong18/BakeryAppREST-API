package com.example.BakeryManagementSystem.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(path = {"{productId}"})
    public Product getProductById(@PathVariable("productId") int id) {
        return productService.getProductById(id);
    }
    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addProducts(product);
    }
    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") int id) {
        productService.deleteProduct(id);
    }
    @PatchMapping(path = "{productId}")
    public void updateProduct(@PathVariable("productId") int id,
                              @RequestBody Product updateProduct) {
        productService.updateProduct(id, updateProduct);
    }
}
