package com.sakila.api.sakilaApp.City;

import com.sakila.api.sakilaApp.Country.CountryDTO;
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
