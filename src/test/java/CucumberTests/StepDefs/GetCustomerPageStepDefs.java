package CucumberTests.StepDefs;
import com.Sakila.api.Sakilaapp.Address.Address;
import com.Sakila.api.Sakilaapp.City.City;
import com.Sakila.api.Sakilaapp.Country.Country;
import com.Sakila.api.Sakilaapp.Customer.*;
import com.Sakila.api.Sakilaapp.Film.*;
import com.Sakila.api.Sakilaapp.Helpers.ModelMapperHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetCustomerPageStepDefs {
    @MockBean
    private CustomerRepository customerRepository;

    CustomerService customerService;
    Long countryId;
    int offset;
    int pageSize;

    private List<Customer> customersData;

    private Page<CustomerDTO> page;

    CustomerController customerController;

    public GetCustomerPageStepDefs() {
        this.customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerService(customerRepository, new ModelMapperHelper(new ModelMapper()));
        customerController = new CustomerController(customerService);
    }
    @Given("Customer data exists in a database")
    public void customer_data_exists_in_a_database() {
        City city1 = new City("London", new Country("United Kingdom"));
        City city2 = new City("London", new Country("United Kingdom"));

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
        customersData = customers;
    }
    @Given("There are no customer filters enabled")
    public void there_are_no_customer_filters_enabled() {
        countryId = -1l;
    }
    @Given("the customer page offset is small enough")
    public void the_customer_page_offset_is_small_enough() {
        offset = 0;
    }
    @Given("The customer page size is large enough")
    public void the_customer_page_size_is_large_enough() {
        pageSize = 25;
    }

    @When("I make a request to fetch the customer data")
    public void i_make_a_request_to_fetch_the_customer_data() {
        when(customerRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                "id")))).thenReturn(new PageImpl<>(customersData));
        page = customerController.getAllCustomer(countryId, "id", offset,pageSize);
    }
    @Then("A page of CustomerDTO data is returned")
    public void a_page_of_customer_dto_data_is_returned() {
        List<CustomerDTO> customerDTOS = page.toList();
        assertEquals(customersData.size(), customerDTOS.size());
        for(int i = 0; i < customersData.size(); i++) {
            assertEquals(customersData.get(i).getId(), customerDTOS.get(i).getId());
        }
    }
}
