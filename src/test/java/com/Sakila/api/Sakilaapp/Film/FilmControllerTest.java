package com.Sakila.api.Sakilaapp.Film;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FilmControllerTest {
    @Mock
    private FilmService filmService;

    private FilmController underTest;

    private String sortByField = "id";
    private int offset = 0;
    private int pageSize = 25;

    @BeforeEach
    void setUp() {
        underTest = new FilmController(filmService);
    }

    @Test
    void testGetAllCustomers() {
        Long categoryId = -1l;
        underTest.getAllFilms(categoryId, sortByField, offset, pageSize);
        verify(filmService).getAllFilms(categoryId, sortByField, offset, pageSize);
    }

    @Test
    void getFilmById() {
        Long filmId = 1l;
        underTest.getFilmById(filmId);
        verify(filmService).getFilmById(filmId);
    }
}