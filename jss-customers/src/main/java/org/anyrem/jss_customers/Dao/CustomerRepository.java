package org.anyrem.jss_customers.Dao;

import org.anyrem.jss_customers.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

        Customer findCustomerByLogin(String login);

}
