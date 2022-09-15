package com.Sakila.api.SakilaApp.City;

import com.Sakila.api.SakilaApp.Country.CountryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    private String city;
    private CountryDTO country;
}
