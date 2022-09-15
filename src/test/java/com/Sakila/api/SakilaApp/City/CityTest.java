package com.Sakila.api.SakilaApp.City;

import com.Sakila.api.SakilaApp.Country.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.util.Assert.isInstanceOf;

class CityTest {

    City city;

    private Country country;

    private String cityName = "London";

    private Long id = 1l;

    @BeforeEach
    void setUp() {
        country = new Country(id, "United Kingdom");
        city = new City(1l,cityName, country);
    }

    @Test
    void getId() {
        assertEquals(id, city.getId());
    }

    @Test
    void getCity() {
        assertEquals(cityName, city.getCity());
    }

    @Test
    void getCountry() {
        assertEquals(country, city.getCountry());
    }

    @Test
    void setId() {
        Long newId = 10l;
        city.setId(newId);
        assertEquals(newId, city.getId());
    }

    @Test
    void setCity() {
        String newName = "Leeds";
        city.setCity("Leeds");
        assertEquals(newName, city.getCity());
    }

    @Test
    void setCountry() {
        Country newCountry = new Country(1l,"France");
        city.setCountry(newCountry);
        assertEquals(newCountry, city.getCountry());
    }

    @Test
    void testEquals() {
        assertEquals(true, city.equals(city));
    }

    @Test
    void testHashCode() {
        isInstanceOf(Integer.class, city.hashCode());
    }

    @Test
    void testToString() {
        isInstanceOf(String.class, city.toString());
    }
}