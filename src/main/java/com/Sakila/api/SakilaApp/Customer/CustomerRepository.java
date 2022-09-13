package com.Sakila.api.SakilaApp.Customer;

import com.Sakila.api.SakilaApp.Film.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByAddresses_City_Country_id(Long id, Pageable pageable);
}