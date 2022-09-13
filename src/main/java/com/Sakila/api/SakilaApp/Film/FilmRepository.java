package com.Sakila.api.SakilaApp.Film;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    Page<Film> findByCategories_id(Long id, Pageable pageable);


}
