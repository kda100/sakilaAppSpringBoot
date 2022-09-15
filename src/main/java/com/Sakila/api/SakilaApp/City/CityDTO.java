package com.Sakila.api.SakilaApp.City;

import com.Sakila.api.SakilaApp.Country.CountryDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    private String city;
    private CountryDTO country;
}
