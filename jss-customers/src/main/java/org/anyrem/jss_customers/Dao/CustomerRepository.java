package org.anyrem.jss_customers.Dao;

import org.anyrem.jss_customers.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

        Customer findCustomerByLogin(String login);

        @Query("SELECT c FROM Customer c WHERE c.login LIKE %:login%")
        List<Customer> findCustomersByMatchingLogin(@Param("login")String login);

}
