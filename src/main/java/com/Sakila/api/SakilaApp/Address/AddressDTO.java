package com.Sakila.api.SakilaApp.Address;

import com.Sakila.api.SakilaApp.City.City;
import com.Sakila.api.SakilaApp.City.CityDTO;
import lombok.Data;

@Data
public class AddressDTO {
    private CityDTO city;
}
