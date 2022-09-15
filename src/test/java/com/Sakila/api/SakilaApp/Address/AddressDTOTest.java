package com.Sakila.api.SakilaApp.Address;

import com.Sakila.api.SakilaApp.City.City;
import com.Sakila.api.SakilaApp.City.CityDTO;
import com.Sakila.api.SakilaApp.Country.Country;
import com.Sakila.api.SakilaApp.Country.CountryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.util.Assert.isInstanceOf;

class AddressDTOTest {
    AddressDTO addressDTO;
    private CountryDTO countryDTO;
    private CityDTO cityDTO;


    @BeforeEach
    void setUp() {
        countryDTO = new CountryDTO("United Kingdom");
        cityDTO = new CityDTO("London", countryDTO);

        addressDTO = new AddressDTO(cityDTO);
    }

    @Test
    void getCity() {
        assertEquals(cityDTO, addressDTO.getCity());
    }

    @Test
    void setCity() {
        CityDTO newCityDTO = new CityDTO("Leeds", countryDTO);
        addressDTO.setCity(newCityDTO);
        assertEquals(newCityDTO, addressDTO.getCity());
    }

    @Test
    void testEquals() {
        assertEquals(true, addressDTO.equals(addressDTO));
    }

    @Test
    void canEqual() {
        assertEquals(true, addressDTO.canEqual(addressDTO));
    }

    @Test
    void testHashCode() {
        isInstanceOf(Integer.class, addressDTO.hashCode());
    }

    @Test
    void testToString() {
        isInstanceOf(String.class, addressDTO.toString());
    }
}