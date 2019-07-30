package org.anyrem.jss_customers.service;

import jdk.jfr.Registered;
import org.anyrem.jss_customers.Dao.CustomerRepository;
import org.anyrem.jss_customers.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }

    @Override
    public Customer findById(long id) {

        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new RuntimeException("ID not found");
        }
    }

    @Override
    public Customer findByLogin(String login) {
        return customerRepository.findCustomerByLogin(login);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
