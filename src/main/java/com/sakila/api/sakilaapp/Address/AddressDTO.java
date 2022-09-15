package com.sakila.api.sakilaapp.Address;

import com.sakila.api.sakilaapp.City.CityDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private CityDTO city;
}
