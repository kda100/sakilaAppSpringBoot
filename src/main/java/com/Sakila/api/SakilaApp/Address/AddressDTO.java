package com.Sakila.api.SakilaApp.Address;

import com.Sakila.api.SakilaApp.City.City;
import com.Sakila.api.SakilaApp.City.CityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private CityDTO city;
}
