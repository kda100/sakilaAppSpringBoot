package com.Sakila.api.SakilaApp.Customer;

import com.Sakila.api.SakilaApp.Address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name= "active")
    private int active;

    @OneToMany
    @JoinColumn(name = "address_id")
    private List<Address> addresses;

    @Column(name = "create_date")
    private Date createDate;

}
