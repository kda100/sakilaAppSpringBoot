package com.Sakila.api.SakilaApp.Film;

import com.Sakila.api.SakilaApp.Category.Category;
import com.Sakila.api.SakilaApp.Category.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {
    private Long id;
    private String title;
    private String description;
    private String rating;
    private List<CategoryDTO> categories;

}
