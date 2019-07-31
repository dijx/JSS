package org.anyrem.jss_addresses.rest;

import org.anyrem.jss_addresses.AddressesGenerator;
import org.anyrem.jss_addresses.entity.Address;
import org.anyrem.jss_addresses.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AddressController {

    @Autowired
    AddressesGenerator addressesGenerator;

    @Autowired
    AddressService addressService;

    @GetMapping("/addresses")
    public List<Address> findAll() {

        return addressService.findAll();
    }

    @PostMapping("/addresses")
    public Address save(Address address) {
        return addressService.save(address);
    }

    @GetMapping("/load")
    public void loadData() {
        addressesGenerator.generate();
    }
}
