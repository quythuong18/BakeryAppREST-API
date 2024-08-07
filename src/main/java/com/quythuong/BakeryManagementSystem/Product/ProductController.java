package com.quythuong.BakeryManagementSystem.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping(path ="api/v1/product")
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
                              @RequestBody Product updatedProduct) {
        productService.updateProduct(id, updatedProduct);
    }
}
