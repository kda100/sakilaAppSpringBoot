package com.Sakila.api.SakilaApp.Film;

import com.Sakila.api.SakilaApp.Exceptions.ResourceNotFoundException;
import com.Sakila.api.SakilaApp.Helpers.ModelMapperHelper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FilmService{
    private FilmRepository filmRepository;
    private ModelMapper mapper;

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public Page<FilmDTO> getAllFilms(Long categoryId, String sortByField, int page, int pageSize) {
        Page<Film> films;
        if(categoryId != null) {
            films = filmRepository.findByCategories_id(categoryId, PageRequest.of(page, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                    sortByField)));
        } else {
            films = filmRepository.findAll(PageRequest.of(page, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                    sortByField)));
        }
        return ModelMapperHelper.mapPage(films, FilmDTO.class, mapper);
    }

    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Film", "Id", id));
    }
}
