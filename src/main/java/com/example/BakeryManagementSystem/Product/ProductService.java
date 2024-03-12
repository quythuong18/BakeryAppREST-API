package com.example.BakeryManagementSystem.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        //return List.of(new Product(1, "loaf", "sdf", 12.2, 3));
        return productRepository.findAll();
    }

    public void addProducts(Product product) {
        Optional<Product> productOptional = productRepository.findProductByName(product.getName());
        if(productOptional.isPresent()) {
            throw new IllegalStateException("The product name exists");
        }
        productRepository.save(product);
    }

    public void deleteProduct(int id) {
        boolean exists = productRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("The product with" + id + " id does not exist");
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(int id, String name, String desc, Double price, Integer quantity) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalStateException("Product with id " + id + "does not exist"));
        if (name != null && !name.isEmpty()) {
            Optional<Product> productOptional = productRepository.findProductByName(name);
            if (productOptional.isPresent()) {
                throw new IllegalStateException("The product name exists");
            }
            product.setName(name);
        }
        if (desc != null && !desc.isEmpty()) {
            product.setDesc(desc);
        }
        if (price != null) {
            product.setPrice(price);
        }
        if (quantity != null) {
            product.setQuantity(quantity);
        }
    }
}
