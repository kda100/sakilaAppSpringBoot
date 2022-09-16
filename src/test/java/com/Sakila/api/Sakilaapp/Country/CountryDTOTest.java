package com.Sakila.api.Sakilaapp.Country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.isInstanceOf;

class CountryDTOTest {

    String countryName = "United Kingdom";
    private CountryDTO countryDTO;


    @BeforeEach
    void setUp() {
        countryDTO = new CountryDTO(countryName);
    }

    @Test
    void getCountry() {
        assertEquals(countryName, countryDTO.getName());
    }

    @Test
    void setCountry() {
        String newCountry = "France";
        countryDTO.setName(newCountry);
        assertEquals(newCountry, countryDTO.getName());
    }

    @Test
    void testEquals() {
        assertEquals(true, countryDTO.equals(countryDTO));
    }


    @Test
    void testHashCode() {
        isInstanceOf(Integer.class, countryDTO.hashCode());
    }

    @Test
    void testToString() {
        isInstanceOf(String.class, countryDTO.toString());
    }
}