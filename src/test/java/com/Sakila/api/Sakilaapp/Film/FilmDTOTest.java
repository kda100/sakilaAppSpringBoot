package com.Sakila.api.Sakilaapp.Film;

import com.Sakila.api.Sakilaapp.Category.CategoryDTO;
import com.Sakila.api.Sakilaapp.Country.CountryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilmDTOTest {
    Long id = 1l;
    String category = "Horror";
    String title = "Titanic";
    String description = "A boat goes down";
    String rating = "15";
    private FilmDTO filmDTO;


    @BeforeEach
    void setUp() {
        List<CategoryDTO> categoryDTOS = new ArrayList<CategoryDTO>();
        categoryDTOS.add(new CategoryDTO(category));
        filmDTO = new FilmDTO(id, "Titanic", "A boat goes down", "15",categoryDTOS);
    }

    @Test
    void getId() {
        assertEquals(id, filmDTO.getId());
    }

    @Test
    void getTitle() {
        assertEquals(title, filmDTO.getTitle());
    }

    @Test
    void getDescription() {
        assertEquals(description, filmDTO.getDescription());
    }

    @Test
    void getRating() {
        assertEquals(rating, filmDTO.getRating());
    }

    @Test
    void getCategories() {

    }

    @Test
    void setId() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setDescription() {
    }

    @Test
    void setRating() {
    }

    @Test
    void setCategories() {
    }

    @Test
    void testToString() {
    }
}