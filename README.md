# Sakila App Spring Boot

This repository contains a Maven Java project created using the Springboot framework to create a backend for the Sakila database provided by MySQL.

The project creates REST Apis, which can be consumed to return the data contained in the Sakila database in JSON format.

This project makes use of the Controller, Service and Repository project structure; popular in Springboot projects, utilises data transfer objects (DTOs) and pagination to reduce data payload, has the ability to sort data by column names and makes use of method queries.

This project also contains cucumber and unit tests and has a CI/CD pipeline to SonarCloud so code coverage in tests can be analysed.

Some popular Maven dependencies used are Lombok, h2database and ModelMapper.
<!-- 
Endspoints:

All films: https://allenapplicationapis.co.uk/api/films

All customers: https://allenapplicationapis.co.uk/api/customers

One film: https://allenapplicationapis.co.uk/api/films/{id}

One customer: https://allenapplicationapis.co.uk/api/customers/{id} -->
