package com.Sakila.api.Sakilaapp.Country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository;

    private CountryService underTest;

    private List<Country> testCountries;

    @BeforeEach
    void setUp() {
        testCountries = new ArrayList<Country>();
        for(Long i = 0l; i < 10; i++) {
            testCountries.add(new Country(i, "name"));
        }
        underTest = new CountryService(countryRepository);
    }

    @Test
    void getAllCountries() {
        doReturn(testCountries).when(countryRepository).findAll();
        List<Country> countries = underTest.getCountries();
        verify(countryRepository).findAll();
        assertEquals(testCountries, countries);
    }
}