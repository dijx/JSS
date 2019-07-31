package org.anyrem.jss_customers.rest;

import org.anyrem.jss_customers.CustomerGenerator;
import org.anyrem.jss_customers.entity.Customer;
import org.anyrem.jss_customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerGenerator customerGenerator;

    @GetMapping(value = "/customers")
    public List<Customer> findAll() {

        return customerService.findAll();
    }

    @GetMapping(value = "/customers", params = "loginExact")
    public Customer findByLoginExact(@RequestParam("loginExact") String login) {

        return customerService.findByLoginExact(login);
    }

    @GetMapping(value = "/customers", params = "loginLike")
    public List<Customer> findByLoginLike(@RequestParam("loginLike") String login) {

        return customerService.findByLoginLike(login);
    }

    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable Long id) {

        return customerService.findById(id);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@NotNull @RequestBody Customer customer) {

        customer.setId(0);
        customerService.save(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@NotNull @RequestBody Customer customer) {

        customerService.save(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public void deleteById(@PathVariable Long id) {

        customerService.delete(id);
    }

    @GetMapping("/load")
    public void loadData() {

        customerGenerator.generate();
    }
}
