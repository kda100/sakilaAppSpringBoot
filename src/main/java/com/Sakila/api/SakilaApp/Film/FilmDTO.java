package com.Sakila.api.SakilaApp.Film;

import com.Sakila.api.SakilaApp.Category.Category;
import com.Sakila.api.SakilaApp.Category.CategoryDTO;
import lombok.Data;
import java.util.List;


@Data
public class FilmDTO {
    private Long id;
    private String title;
    private String description;
    private String rating;
    private List<CategoryDTO> categories;

}
