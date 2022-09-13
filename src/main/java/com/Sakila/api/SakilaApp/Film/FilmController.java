package com.Sakila.api.SakilaApp.Film;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
@AllArgsConstructor
@CrossOrigin()
public class FilmController {
    private FilmService filmService;


    @GetMapping()
    public Page<FilmDTO> getAllFilms(@RequestParam(name="categoryId", required = false) Long categoryId,
                                                  @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortByField,
                                                  @RequestParam(name = "page", defaultValue = "1") int page,
                                                  @RequestParam(name = "pageSize", defaultValue = "25") int pageSize) {
        return filmService.getAllFilms(categoryId, sortByField, page, pageSize);
    }

    @GetMapping("{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.getFilmById(id);
    }
}
