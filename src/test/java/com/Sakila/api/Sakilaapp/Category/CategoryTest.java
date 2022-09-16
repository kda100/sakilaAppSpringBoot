package com.Sakila.api.Sakilaapp.Category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.util.Assert.isInstanceOf;

class CategoryTest {
    Long categoryId = 1l;
    String categoryName = "Horror";
    private Category category;

    @BeforeEach
    void setup() {
        category = new Category(categoryId, categoryName);
    }

    @Test
    void getId() {
        assertEquals(categoryId, category.getId());
    }

    @Test
    void getName() {
        assertEquals(categoryName, category.getName());
    }

    @Test
    void setId() {
        Long newId = 10l;
        category.setId(newId);
        assertEquals(newId, category.getId());
    }

    @Test
    void setName() {
        String newCategoryName = "Comedy";
        category.setName(newCategoryName);
        assertEquals(newCategoryName, category.getName());
    }

    @Test
    void testToString() {
        isInstanceOf(String.class, category.toString());
    }
}