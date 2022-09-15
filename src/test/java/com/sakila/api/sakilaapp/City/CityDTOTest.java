package com.sakila.api.sakilaapp.City;

import com.sakila.api.sakilaapp.Country.CountryDTO;
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
        assertEquals(cityName, cityDTO.getCity());

    }

    @Test
    void getCountry() {
        assertEquals(countryDTO, cityDTO.getCountry());
    }

    @Test
    void setCity() {
        String newCityName = "Leeds";
        cityDTO.setCity(newCityName);
        assertEquals(newCityName, cityDTO.getCity());
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