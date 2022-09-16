package com.Sakila.api.Sakilaapp.City;

import com.Sakila.api.Sakilaapp.Country.CountryDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    private String name;
    private CountryDTO country;
}
