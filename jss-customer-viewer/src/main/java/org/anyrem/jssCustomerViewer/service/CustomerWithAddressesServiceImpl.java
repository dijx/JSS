package org.anyrem.jssCustomerViewer.service;

import org.anyrem.jssCustomerViewer.model.Address;
import org.anyrem.jssCustomerViewer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CustomerWithAddressesServiceImpl implements CustomerWithAddressesService {

    private final static Logger logger = Logger.getLogger(CustomerServiceRestClientImpl.class.getName());

    private CustomerService customerService;
    private AddressService addressService;

    @Autowired
    public CustomerWithAddressesServiceImpl(CustomerService customerService, AddressService addressService) {
        this.customerService = customerService;
        this.addressService = addressService;
    }

    @Override
    public List<Customer> getCustomers() {

        List<Customer> customers = customerService.getCustomers();

        List<Customer> customersWithAddresses = customers
                .stream()
                .map(customer -> {
                    logger.info(">>CUSTOMER: "+customer);
                    customer.getAddresses()
                            .forEach(addressId -> {
                                Optional<Address> tmpAddress = addressService.getAddress(addressId);

                                if (tmpAddress.isPresent()) {
                                    customer.addAddressFull(tmpAddress.get());
                                } else {
                                    logger.info(">>No such address ID found: "+addressId);
                                }
                                logger.info("ADDRESS: "+tmpAddress);
                            });
                    logger.info(">>CUSTOMER: "+customer);
                    return customer;
                })
                .collect(Collectors.toList());

        return customersWithAddresses;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

    }

    @Override
    public Customer getCustomer(int theId) {
        return null;
    }

    @Override
    public void deleteCustomer(int theId) {

    }
}
