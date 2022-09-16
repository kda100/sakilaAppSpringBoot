package com.Sakila.api.Sakilaapp.Country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.isInstanceOf;

class CountryTest {

    private Country country;

    private String countryName = "United Kingdom";

    private Long id = 1l;


    @BeforeEach
    void setUp() {
        country = new Country(id, "United Kingdom");
    }

    @Test
    void getId() {
        assertEquals(id, country.getId());
    }

    @Test
    void getCountry() {
        assertEquals(countryName, country.getName());
    }

    @Test
    void setId() {
        Long newId = 10l;
        country.setId(newId);
        assertEquals(newId, country.getId());
    }

    @Test
    void setCountry() {
        String newCountry = "France";
        country.setName(newCountry);
        assertEquals(newCountry, country.getName());
    }

    @Test
    void testEquals() {
        assertEquals(true, country.equals(country));
    }

    @Test
    void testHashCode() {
        isInstanceOf(Integer.class, country.hashCode());
    }

    @Test
    void testToString() {
        isInstanceOf(String.class, country.toString());
    }
}