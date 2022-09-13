package com.Sakila.api.SakilaApp.Country;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {
    private CountryRepository countryRepository;
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
