package com.Sakila.api.SakilaApp.Category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    private CategoryController underTest;

    @BeforeEach
    void setUp() {
        underTest = new CategoryController(categoryService);
    }

    @Test
    void getCategories() {
        underTest.getCategories();
        verify(categoryService).getCategories();
    }
}