package com.sakila.api.sakilaApp.Helpers;

import com.sakila.api.sakilaApp.Category.Category;
import com.sakila.api.sakilaApp.Film.Film;
import com.sakila.api.sakilaApp.Film.FilmDTO;
import com.sakila.api.sakilaApp.Language.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

class ModelMapperHelperTest {
    ModelMapperHelper modelMapperHelper;

    @BeforeEach
    void setUp() {
        modelMapperHelper = new ModelMapperHelper(new ModelMapper());
    }

    @Test
    void mapsFilmsToDTOs() {
        final List<Film> films = new ArrayList<Film>();
        final List<Category> categories = new ArrayList<Category>();
        categories.add(new Category("Horror"));

        for(int i=0; i<10; i++) {
            final Film film = new Film("Titanic", "A boat crashed", 2000, new Language("English"),10,10.99,
                    "15",
                    125, 100, categories);
            films.add(film);
        }
        Page<Film> filmPage = new PageImpl<>(films);
        Page filmDTOPage = modelMapperHelper.mapPage(filmPage, FilmDTO.class);
        assertThat(filmDTOPage.getContent().get(0), instanceOf(FilmDTO.class));
    }
}