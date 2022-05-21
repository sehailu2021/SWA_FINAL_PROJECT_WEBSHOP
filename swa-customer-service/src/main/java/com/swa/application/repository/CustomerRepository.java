package com.swa.application.repository;

import com.swa.application.domain.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepository extends MongoRepository<Customer, String> {
}
