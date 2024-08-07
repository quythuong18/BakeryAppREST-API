package com.quythuong.BakeryManagementSystem.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public void deleteProduct(Integer id) {
        boolean exists = productRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("The product with" + id + " id does not exist");
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(int id, Product updateProduct) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalStateException("Product with id " + id + "does not exist"));

        product.setName(updateProduct.getName() != null ? updateProduct.getName() : product.getName());
        product.setCategory(updateProduct.getCategory() != null ? updateProduct.getCategory() : product.getCategory());
        product.setDescription(updateProduct.getDescription() != null ? updateProduct.getDescription() : product.getDescription());
        product.setPrice(updateProduct.getPrice() != null ? updateProduct.getPrice() : product.getPrice());
        product.setQuantity(updateProduct.getQuantity() != null ? updateProduct.getQuantity() : product.getQuantity());
        product.setImgPath(updateProduct.getImgPath() != null ? updateProduct.getImgPath() : product.getImgPath());

        productRepository.save(product);
//        return ResponseEntity.ok(product);
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalStateException("Product with id " + id + "does not exist"));
    }
}
