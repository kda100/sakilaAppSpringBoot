package com.Sakila.api.Sakilaapp.Customer;

import com.Sakila.api.Sakilaapp.Exceptions.ResourceNotFoundException;
import com.Sakila.api.Sakilaapp.Helpers.ModelMapperHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ModelMapperHelper modelMapperHelper;

    private CustomerService underTest;

    private Page<CustomerDTO> customerDTOPage;
    private Long customerId = 10l;
    private String sortByField = "id";
    private int offset = 0;
    private int pageSize = 25;


    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository, modelMapperHelper);
    }


    @Test
    void getsAllCustomersWithNoCountryFilter() {
        Long countryId = -1l;
        doReturn(null).when(modelMapperHelper).mapPage(null, CustomerDTO.class);
        underTest.getAllCustomers(countryId, sortByField, offset, pageSize);
        verify(customerRepository).findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                sortByField)));

    }

    @Test
    void getsSomeCustomersWithFilter() {
        Long countryId = 1l;
        doReturn(null).when(modelMapperHelper).mapPage(null, CustomerDTO.class);
        underTest.getAllCustomers(countryId, sortByField, offset, pageSize);
        verify(customerRepository).findByAddress_City_Country_id(countryId,
                PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                sortByField)));
    }

    @Test
    void getsCustomerWithId() {
        doReturn(true).when(customerRepository).existsById(customerId);
        doReturn(Optional.of(new Customer())).when(customerRepository).findById(customerId);
        underTest.getCustomerById(customerId);
        verify(customerRepository).findById(customerId);
    }

    @Test
    void throwsExceptionWhenIdDoesNotExist() {
        doReturn(false).when(customerRepository).existsById(customerId);
        assertThrows(ResourceNotFoundException.class, () -> underTest.getCustomerById(customerId));
    }
}