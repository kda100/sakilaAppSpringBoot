package com.Sakila.api.SakilaApp.Film;

import com.Sakila.api.SakilaApp.Customer.Customer;
import com.Sakila.api.SakilaApp.Helpers.ModelMapperHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FilmServiceTest {

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private ModelMapperHelper modelMapperHelper;

    private FilmService underTest;
    private Long filmId = 10l;
    private String sortByField = "id";
    private int offset = 0;
    private int pageSize = 25;

    @BeforeEach
    void setUp() {
        underTest = new FilmService(filmRepository, modelMapperHelper);
    }

    @Test
    void getAllFilmsWithNoCategoryFilter() {
        Long categoryId = -1l;
        doReturn(null).when(modelMapperHelper).mapPage(null, FilmDTO.class);
        underTest.getAllFilms(categoryId, sortByField, offset, pageSize);
        verify(filmRepository).findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                sortByField)));
    }

    @Test
    void getSomeCustomersWithFilter() {
        Long categoryId = 1l;
        doReturn(null).when(modelMapperHelper).mapPage(null, FilmDTO.class);
        underTest.getAllFilms(categoryId, sortByField, offset, pageSize);
        verify(filmRepository).findByCategories_id(categoryId, PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                sortByField)));
    }
}