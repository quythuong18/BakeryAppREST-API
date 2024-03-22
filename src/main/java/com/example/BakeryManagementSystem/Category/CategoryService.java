package com.example.BakeryManagementSystem.Category;

import com.example.BakeryManagementSystem.Product.Product;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(int Id) {
        boolean exists = categoryRepository.existsById(Id);
        if(!exists) {
            throw new IllegalStateException("The category with" + Id + " id does not exist");
        }
        categoryRepository.deleteById(Id);
    }

    @Transactional
    public void updateCategory(int id, Category updateCategory) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category with id " + id + " does not exist"));
        category.setName(updateCategory.getName() != null ? updateCategory.getName() : category.getName());
        category.setImgPath(updateCategory.getImgPath() != null ? updateCategory.getImgPath() : category.getImgPath());
        categoryRepository.save(category);
    }

    public List<Product> getProductByCate(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category with id " + id + " does not exist"));
        return category.getProductList();
    }

    public Category getACategory(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category with id " + id + " does not exist"));
        return  category;
    }
}
