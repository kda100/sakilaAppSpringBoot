package com.Sakila.api.SakilaApp.Language;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "language")
@Setter(value = AccessLevel.NONE)
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Integer id;

    @Column(name = "name")
    @NotBlank
    private String name;

    public Language(String name) {
        this.name = name;
    }
}
