package com.Sakila.api.SakilaApp.Country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
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
        assertEquals(countryName, countryDTO.getCountry());
    }

    @Test
    void setCountry() {
        String newCountry = "France";
        countryDTO.setCountry(newCountry);
        assertEquals(newCountry, countryDTO.getCountry());
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