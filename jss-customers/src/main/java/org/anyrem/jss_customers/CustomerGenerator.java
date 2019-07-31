package org.anyrem.jss_customers;

import org.anyrem.jss_customers.entity.Customer;
import org.anyrem.jss_customers.service.CustomerService;
import org.anyrem.jss_customers.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomerGenerator {

    @Autowired
    private CustomerService customerService;

    public void generate () {

        List<Customer> customerList = new ArrayList<>();
        HashSet<Long> addressSet = new HashSet<>();

        customerList.add(new Customer("anyrem", "pass123"));
        customerList.add(new Customer("jasiek", "pass123"));
        customerList.add(new Customer("krzysiek", "pass123"));

        addressSet.add(1L);
        addressSet.add(2L);
        customerList.add(new Customer("patryk", "pass123", addressSet));


        customerList.forEach(customer -> {
            if (!(customerService.findByLoginExact(customer.getLogin()) instanceof  Customer)) {
                customerService.save(customer);
            }
        });

    }
}
