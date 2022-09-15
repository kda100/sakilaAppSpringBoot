package com.sakila.api.sakilaapp.Customer;
import com.sakila.api.sakilaapp.Exceptions.ResourceNotFoundException;
import com.sakila.api.sakilaapp.Helpers.ModelMapperHelper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperHelper modelMapperHelper;
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
        return modelMapperHelper.mapPage(customers, CustomerDTO.class);
    }

    public Customer getCustomerById(Long id) {
        if(customerRepository.existsById(id)) {
            return customerRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundException("Customer", "Id", id);
        }
    }
}
