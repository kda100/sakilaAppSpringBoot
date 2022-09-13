package com.Sakila.api.SakilaApp.City;

import com.Sakila.api.SakilaApp.Country.Country;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    @Column(name = "city")
    private String city;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;
}
