package com.sakila.api.sakilaApp.Address;

import com.sakila.api.sakilaApp.City.CityDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private CityDTO city;
}
