package org.anyrem.jss_addresses.rest;

import org.anyrem.jss_addresses.AddressesGenerator;
import org.anyrem.jss_addresses.entity.Address;
import org.anyrem.jss_addresses.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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

    @GetMapping("/addresses/{id}")
    public Address findById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @GetMapping(value = "/addresses", params = "id")
    public List<Address> findByIds(@RequestParam Long[] id) {
        return addressService.findByIds(id);
    }

    @PostMapping("/addresses")
    public Address save(@RequestBody @NotNull Address address) {

        address.setId(0L);
        return addressService.save(address);
    }

    @PutMapping("/addresses")
    public Address update(@RequestBody @NotNull Address address) {

        return addressService.save(address);
    }

    @GetMapping("/load")
    public void loadData() {
        addressesGenerator.generate();
    }
}
