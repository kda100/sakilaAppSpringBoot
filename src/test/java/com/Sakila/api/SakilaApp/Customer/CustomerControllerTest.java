package com.Sakila.api.SakilaApp.Customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    private CustomerController underTest;


    private String sortByField = "id";
    private int offset = 0;
    private int pageSize = 25;

    @BeforeEach
    void setUp() {
        underTest = new CustomerController(customerService);
    }

    @Test
    void testGetAllCustomers() {
        Long countryId = -1l;
        underTest.getAllCustomer(countryId, sortByField, offset, pageSize);
        verify(customerService).getAllCustomers(countryId, sortByField, offset, pageSize);
    }

    @Test
    void testGetOneCustomer() {
        Long customerId = 1l;
        underTest.getCustomerById(customerId);
        verify(customerService).getCustomerById(customerId);
    }

}