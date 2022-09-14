package com.Sakila.api.SakilaApp.Film;

import com.Sakila.api.SakilaApp.Category.Category;
import com.Sakila.api.SakilaApp.Language.Language;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long id;

    @Column(name = "title", nullable = false)
    @NotBlank
    private String title;

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "release_year", nullable = false)
    @NotBlank
    private int releaseYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="language_id", nullable = false)
    private Language language;

    @Column(name = "rental_duration", nullable = false)
    private int rentalDuration;

    @Column(name = "rental_rate", nullable = false)
    private double rentalRate;

    @Column(name = "rating", nullable = false)
    private String rating;

    @Column(name = "length", nullable = false)
    private int length;

    @Column(name = "replacement_cost", nullable = false)
    private double replacementCost;

    @ManyToMany(cascade = CascadeType.ALL)
    @NotEmpty
    @JoinTable(
            name = "film_category",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<Category> categories;

    public Film(String title, String description, int releaseYear, Language language, int rentalDuration,
                double rentalRate, String rating, int length, double replacementCost, List<Category> categories) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.language = language;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.rating = rating;
        this.length = length;
        this.replacementCost = replacementCost;
        this.categories = categories;
    }
}
