package com.Sakila.api.Sakilaapp.Address;

import com.Sakila.api.Sakilaapp.City.CityDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private CityDTO city;
}
