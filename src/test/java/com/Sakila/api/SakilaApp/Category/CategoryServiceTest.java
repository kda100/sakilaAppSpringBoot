package com.Sakila.api.SakilaApp.Category;

import com.Sakila.api.SakilaApp.Film.FilmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService underTest;

    private List<Category> testCategories;

    @BeforeEach
    void setUp() {
        testCategories = new ArrayList<Category>();
        for(Long i = 0l; i < 10; i++) {
            testCategories.add(new Category(i, "name"));
        }
        underTest = new CategoryService(categoryRepository);
    }

    @Test
    void getAllCategories() {
        doReturn(testCategories).when(categoryRepository).findAll();
        List<Category> categories = underTest.getCategories();
        verify(categoryRepository).findAll();
        assertEquals(testCategories, categories);
    }
}