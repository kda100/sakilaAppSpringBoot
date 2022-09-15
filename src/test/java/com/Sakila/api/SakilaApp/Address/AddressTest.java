package com.Sakila.api.SakilaApp.Address;

import com.Sakila.api.SakilaApp.City.City;
import com.Sakila.api.SakilaApp.Country.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.isInstanceOf;

class AddressTest {
    private Long id = 1l;
    private String countryName = "United Kingdom";
    private  String cityName = "city";
    private String addressName = "address";
    private String districtName = "district";
    private String postCode = "324324";
    private String phoneNumber = "07976116542";

    City city;
    Country country;
    Address address;



    @BeforeEach
    void setUp() {
        country = new Country(countryName);
        city = new City(cityName, country);
        address = new Address(id, addressName, districtName, postCode, phoneNumber, city);
    }

    @Test
    void getId() {
        assertEquals(id, address.getId());
    }

    @Test
    void getAddress() {
        assertEquals(addressName, address.getAddress());
    }

    @Test
    void getDistrict() {
        assertEquals(districtName, address.getDistrict());
    }

    @Test
    void getPostalCode() {
        assertEquals(postCode, address.getPostalCode());
    }

    @Test
    void getPhoneNumber() {
        assertEquals(phoneNumber, address.getPhoneNumber());
    }

    @Test
    void getCity() {
        assertEquals(city, address.getCity());
    }

    @Test
    void setId() {
        address.setId(10l);
        assertEquals(Optional.of(10l).get(), address.getId());
    }

    @Test
    void setAddress() {
        address.setAddress("New address");
        assertEquals("New address", address.getAddress());
    }

    @Test
    void setDistrict() {
        address.setDistrict("New district");
        assertEquals("New district", address.getDistrict());
    }

    @Test
    void setPostalCode() {
        address.setPostalCode("New postcode");
        assertEquals("New postcode", address.getPostalCode());
    }

    @Test
    void setPhoneNumber() {
        address.setPostalCode("New phoneNumber");
        assertEquals("New phoneNumber", address.getPhoneNumber());
    }

    @Test
    void setCity() {
        City newCity = new City("new city", country);
        address.setCity(newCity);
        assertEquals(newCity, address.getCity());
    }

    @Test
    void testEquals() {
        assertEquals(true, address.equals(address));
    }

    @Test
    void canEqual() {
        assertEquals(true, address.canEqual(address));
    }

    @Test
    void testHashCode() {
        isInstanceOf(Integer.class, address.hashCode());
    }

    @Test
    void testToString() {
        isInstanceOf(String.class, address.toString());
    }
}