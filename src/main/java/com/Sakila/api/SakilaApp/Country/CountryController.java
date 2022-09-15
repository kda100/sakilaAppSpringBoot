package com.Sakila.api.SakilaApp.Country;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
@CrossOrigin
public class CountryController {
    private CountryService countryService;

    @GetMapping()
    public List<Country> getCountries() {
        return countryService.getCountries();
    }
}
