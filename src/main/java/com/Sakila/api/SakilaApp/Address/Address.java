package com.Sakila.api.SakilaApp.Address;

import com.Sakila.api.SakilaApp.City.City;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "address", nullable = false)
    @NotBlank
    private String address;

    @Column(name = "district", nullable = false)
    @NotBlank
    private String district;

    @Column(name = "postal_code", nullable = false)
    @NotBlank
    private String postalCode;

    @Column(name="phone", nullable = false)
    @NotBlank
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Address(String address, String district, String postalCode, String phoneNumber, City city) {
        this.address = address;
        this.district = district;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }
}
