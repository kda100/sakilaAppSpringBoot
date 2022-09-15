package com.sakila.api.sakilaApp.Customer;

import com.sakila.api.sakilaApp.Address.Address;
import com.sakila.api.sakilaApp.City.City;
import com.sakila.api.sakilaApp.Country.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository underTest;

    private City city1 = new City("London", new Country("United Kingdom"));
    private City city2 = new City("London", new Country("United Kingdom"));


    @BeforeEach
    void setUp(){
        final List<Customer> customers = new ArrayList<Customer>();
        for(int i = 0; i < 10; i++) {
            Address address;
            if(i % 2 == 0) {
                address = new Address("14 Springboot Street",
                        "Springboot",
                        "123456",
                        "07976116542",
                        city1);
            } else {
                address = new Address("14 Springboot Street",
                        "Springboot",
                        "123456",
                        "07976116542",
                        city2);
            }
            final Customer customer = new Customer("Kiyron",
                    "Allen",
                    "kda_100@aol.com",
                    1, address);
            customers.add(customer);
        }
        underTest.saveAll(customers);
    }

    @Test
    void checkFindByCountryIdFindsCorrectData() {
        //given
        final Long countryId = city1.getCountry().getId();
        //when
        Page<Customer> customerPage = underTest.findByAddress_City_Country_id(countryId, PageRequest.of(0, 25));
        final List<Customer> customers = customerPage.getContent();
        customers.forEach(customer -> {
            assertEquals(countryId, customer.getAddress().getCity().getCountry().getId());
        });
        //then
    }
}