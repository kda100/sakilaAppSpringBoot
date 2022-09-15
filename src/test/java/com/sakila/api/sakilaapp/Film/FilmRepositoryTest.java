package com.sakila.api.sakilaapp.Film;

import com.sakila.api.sakilaapp.Category.Category;
import com.sakila.api.sakilaapp.Language.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FilmRepositoryTest {

    @Autowired
    private FilmRepository underTest;

    private Category category1 = new Category("Horror");
    private Category category2 = new Category("Comedy");

    @BeforeEach
    void setUp() {
        final List<Film> films = new ArrayList<Film>();

        for(int i=0; i<10; i++) {
            final List<Category> categories = new ArrayList<Category>();
            if(i % 2 == 0) {
                categories.add(category1);
            } else {
                categories.add(category2);
            }
            final Film film = new Film("Titanic", "A boat crashed", 2000, new Language("English"),10,10.99,
                    "15",
                    125, 100, categories);
            films.add(film);
        }
        System.out.println(films);
        underTest.saveAll(films);
        System.out.println("films: " + underTest.findAll());
    }

    @Test
    void checkFindByCategoryIdFindsCorrectData() {
        final Long categoryId = category1.getId();
        Page<Film> filmPage = underTest.findByCategories_id(categoryId, PageRequest.of(0, 25));
        final List<Film> films = filmPage.getContent();
        films.forEach(film -> {
            assertEquals(categoryId, film.getCategories().get(0).getId());
        });
    }
}