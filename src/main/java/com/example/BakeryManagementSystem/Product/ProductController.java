package com.example.BakeryManagementSystem.Product;

import org.springframework.beans.factory.annotation.Autowired;
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
