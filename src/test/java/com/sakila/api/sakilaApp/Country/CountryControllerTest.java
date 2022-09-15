package com.sakila.api.sakilaApp.Country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CountryControllerTest {

    @Mock
    private CountryService countryService;
    private CountryController underTest;

    @BeforeEach
    void setUp() {
        underTest = new CountryController(countryService);
    }

    @Test
    void getAllCountries() {
        underTest.getCountries();
        verify(countryService).getCountries();
    }
}