package com.Sakila.api.SakilaApp.City;

import com.Sakila.api.SakilaApp.Country.CountryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDTO {
    private String city;
    private CountryDTO country;
}
