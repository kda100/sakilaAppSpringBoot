package com.Sakila.api.Sakilaapp.City;

import com.Sakila.api.Sakilaapp.Country.CountryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityDTOTest {
    private String cityName = "London";
    private CityDTO cityDTO;

    private CountryDTO countryDTO;

    @BeforeEach
    void setUp() {
        countryDTO = new CountryDTO("United Kingdom");
        cityDTO = new CityDTO(cityName, countryDTO);
    }

    @Test
    void getCity() {
        assertEquals(cityName, cityDTO.getName());

    }

    @Test
    void getCountry() {
        assertEquals(countryDTO, cityDTO.getCountry());
    }

    @Test
    void setCity() {
        String newCityName = "Leeds";
        cityDTO.setName(newCityName);
        assertEquals(newCityName, cityDTO.getName());
    }

    @Test
    void setCountry() {
        CountryDTO newCountryDTO = new CountryDTO("France");
        cityDTO.setCountry(newCountryDTO);
        assertEquals(newCountryDTO, cityDTO.getCountry());
    }

    @Test
    void testToString() {
    }
}