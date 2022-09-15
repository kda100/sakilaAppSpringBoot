package com.sakila.api.sakilaApp.Address;

import com.sakila.api.sakilaApp.City.CityDTO;
import com.sakila.api.sakilaApp.Country.CountryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.isInstanceOf;

class AddressDTOTest {
    private AddressDTO addressDTO;
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
    void testHashCode() {
        isInstanceOf(Integer.class, addressDTO.hashCode());
    }

    @Test
    void testToString() {
        isInstanceOf(String.class, addressDTO.toString());
    }
}