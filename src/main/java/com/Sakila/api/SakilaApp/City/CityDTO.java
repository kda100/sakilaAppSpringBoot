package com.Sakila.api.SakilaApp.City;

import com.Sakila.api.SakilaApp.Country.Country;
import com.Sakila.api.SakilaApp.Country.CountryDTO;
import lombok.Data;

@Data
public class CityDTO {
    private String city;
    private CountryDTO country;
}
