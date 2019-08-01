package org.anyrem.jss_addresses;

import org.anyrem.jss_addresses.entity.Address;
import org.anyrem.jss_addresses.entity.Country;
import org.anyrem.jss_addresses.entity.LocationUnit;
import org.anyrem.jss_addresses.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressesGenerator {

    @Autowired
    private AddressService addressService;

    public void generate() {

        List<Address> addressesList = new ArrayList<>();

        addressesList.add(
                new Address(
                        LocationUnit.ULICA,
                        "Majakowskiego",
                        "12",
                        null,
                        "Siemianowice Slaskie",
                        Country.POLAND
                )
        );

        addressesList.add(
                new Address(
                        LocationUnit.PLAC,
                        "Zbawiciela",
                        "12B",
                        "36A",
                        "Siemianowice Slaskie",
                        Country.POLAND
                )
        );

        addressesList.forEach(address -> {
            if (!(addressService.findAll().contains(address))) {
                addressService.save(address);
            }
        });

    }
}
