package org.anyrem.jss_addresses.service;

import org.anyrem.jss_addresses.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAll();
    Address save(Address address);
}
