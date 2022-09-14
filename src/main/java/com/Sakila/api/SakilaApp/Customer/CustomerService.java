package com.Sakila.api.SakilaApp.Customer;

import com.Sakila.api.SakilaApp.Exceptions.ResourceNotFoundException;
import com.Sakila.api.SakilaApp.Film.Film;
import com.Sakila.api.SakilaApp.Helpers.ModelMapperHelper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    private ModelMapper mapper;
    public Page<CustomerDTO> getAllCustomers(Long countryId, String sortByField, int offset, int pageSize) {
        Page<Customer> customers;
        if(countryId != -1) {
            customers = customerRepository.findByAddress_City_Country_id(countryId,
                PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                    sortByField)));
        }  else {
            customers = customerRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                    sortByField)));
        }
        return ModelMapperHelper.mapPage(customers, CustomerDTO.class, mapper);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Film", "Id", id));
    }
}
