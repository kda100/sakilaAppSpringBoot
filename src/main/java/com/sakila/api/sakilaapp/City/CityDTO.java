package com.sakila.api.sakilaapp.City;

import com.sakila.api.sakilaapp.Country.CountryDTO;
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
