package com.Sakila.api.SakilaApp.Film;

import com.Sakila.api.SakilaApp.Category.Category;
import com.Sakila.api.SakilaApp.Language.Language;
import lombok.*;

import javax.persistence.*;
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
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "release_year", nullable = false)
    private String releaseYear;

    @ManyToOne()
    @JoinColumn(name="language_id")
    private Language language;

    @Column(name = "rental_duration", nullable = false)
    private int rentalDuration;

    @Column(name = "rental_rate", nullable = false)
    private int rentalRate;

    @Column(name = "rating", nullable = false)
    private String rating;

    @Column(name = "length", nullable = false)
    private int length;

    @Column(name = "replacement_cost", nullable = false)
    private double replacementCost;

    @ManyToMany()
    @JoinTable(
            name = "film_category",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<Category> categories;


}
