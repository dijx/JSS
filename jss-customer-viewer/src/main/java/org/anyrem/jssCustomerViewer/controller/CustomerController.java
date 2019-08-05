package org.anyrem.jssCustomerViewer.controller;

import org.anyrem.jssCustomerViewer.model.Address;
import org.anyrem.jssCustomerViewer.model.Customer;
import org.anyrem.jssCustomerViewer.service.CustomerService;
import org.anyrem.jssCustomerViewer.service.CustomerWithAddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;
    private CustomerWithAddressesService customerWithAddressesService;

    @Autowired
    public CustomerController(CustomerService customerService,
                              CustomerWithAddressesService customerWithAddressesService) {
        this.customerService = customerService;
        this.customerWithAddressesService = customerWithAddressesService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {

        model.addAttribute("customers", customerWithAddressesService.getCustomers());

        return "list-customers";
    }

    @GetMapping("/addCustomer")
    public String addCustomer (Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }


}
