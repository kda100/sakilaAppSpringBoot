package com.Sakila.api.SakilaApp.City;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private  CityRepository cityRepository;

    public List<City> getCities() {
        return cityRepository.findAll();
    }
}
