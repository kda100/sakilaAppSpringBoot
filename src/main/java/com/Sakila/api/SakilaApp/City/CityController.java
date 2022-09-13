package com.Sakila.api.SakilaApp.City;

import com.Sakila.api.SakilaApp.Category.Category;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
@CrossOrigin()
public class CityController {
    private CityService cityService;
    @GetMapping()
    public List<City> getCities() {
        return cityService.getCities();
    }

}
