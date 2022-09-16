package com.Sakila.api.Sakilaapp.Film;

import com.Sakila.api.Sakilaapp.Category.CategoryDTO;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {
    private Long id;
    private String title;
    private String description;
    private String rating;
    private List<CategoryDTO> categories;

}
