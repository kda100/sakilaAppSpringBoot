package com.Sakila.api.SakilaApp.Category;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@CrossOrigin()
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }
}
