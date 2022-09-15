package com.sakila.api.sakilaapp.Customer;

import com.sakila.api.sakilaapp.Address.AddressDTO;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int active;
    private AddressDTO address;
}
