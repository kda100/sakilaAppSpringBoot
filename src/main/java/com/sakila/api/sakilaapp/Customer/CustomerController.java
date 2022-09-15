package com.sakila.api.sakilaapp.Customer;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
@CrossOrigin
public class CustomerController {
    private CustomerService customerService;

    @GetMapping()
    public Page<CustomerDTO> getAllCustomer(@RequestParam(name = "countryId", required = false, defaultValue = "-1") Long countryId,
                                                  @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortByField,
                                            @RequestParam(name = "offset", defaultValue = "0") int offset,
                                            @RequestParam(name = "pageSize", defaultValue = "25") int pageSize) {
        return customerService.getAllCustomers(countryId, sortByField, offset, pageSize);
    }

    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
}
