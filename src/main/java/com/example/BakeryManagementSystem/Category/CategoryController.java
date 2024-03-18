package com.example.BakeryManagementSystem.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {
    CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
    @DeleteMapping(path = "{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") int Id) {
        categoryService.deleteCategory(Id);
    }

    @PutMapping(path = "{categoryId}")
    public void updateCategory(@PathVariable("categoryId") int Id,
                                @RequestBody Category updateCategory) {
        categoryService.updateCategory(Id, updateCategory);
    }
}
