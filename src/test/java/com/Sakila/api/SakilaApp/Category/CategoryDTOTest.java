package com.Sakila.api.SakilaApp.Category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.util.Assert.isInstanceOf;

class CategoryDTOTest {
    private String categoryName = "Horror";
    private CategoryDTO categoryDTO;

    @BeforeEach
    void setUp() {
        categoryDTO = new CategoryDTO(categoryName);
    }

    @Test
    void getName() {
        assertEquals(categoryName, categoryDTO.getName());
    }

    @Test
    void setName() {
        String newCategoryName = "Comedy";
        categoryDTO.setName(newCategoryName);
        assertEquals(newCategoryName, categoryDTO.getName());
    }

    @Test
    void testToString() {
        isInstanceOf(String.class, categoryDTO.toString());
    }
}