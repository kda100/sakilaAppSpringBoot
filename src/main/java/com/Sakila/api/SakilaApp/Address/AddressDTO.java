package com.Sakila.api.SakilaApp.Address;

import com.Sakila.api.SakilaApp.City.City;
import com.Sakila.api.SakilaApp.City.CityDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private CityDTO city;
}
