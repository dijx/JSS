package org.anyrem.jss_customers.service;

import org.anyrem.jss_customers.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
//    List<Customer> findAllbyLastName(String lastname);
    Customer findById(long id);
    Customer findByLogin(String login);
    void save(Customer customer);


}
