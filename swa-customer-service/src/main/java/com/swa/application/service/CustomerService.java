package com.swa.application.service;

import com.swa.application.exception.DBException;
import com.swa.application.repository.CustomerRepository;
import com.swa.application.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void add(Customer customer) throws  DBException {
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new DBException(e.getMessage());
        }
    }

    public void update(Customer customer) throws DBException {
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new DBException(e.getMessage());
        }
    }

    public Customer findById(String customerId) throws  DBException {
        return customerRepository.findById(customerId).orElseThrow(
                () -> new DBException("Customer by id " + customerId + " not found!")
        );
    }

    public void delete(String customerId) throws DBException {
        try {
            var customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new DBException("Customer by id " + customerId + " not found!")
            );
            customerRepository.delete(customer);
        } catch (Exception e) {
            throw new DBException(e.getMessage());
        }

    }

    public List<Customer> getAll() throws DBException {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            throw new DBException(e.getMessage());
        }
    }
}
