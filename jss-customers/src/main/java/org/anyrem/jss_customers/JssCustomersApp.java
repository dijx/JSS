package org.anyrem.jss_customers;

import org.anyrem.jss_customers.entity.Customer;
import org.anyrem.jss_customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JssCustomersApp {

	public static void main(String[] args) {

		SpringApplication.run(JssCustomersApp.class, args);
	}

}
