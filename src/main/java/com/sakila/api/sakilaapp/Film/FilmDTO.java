package com.sakila.api.sakilaapp.Film;

import com.sakila.api.sakilaapp.Category.CategoryDTO;
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
