package org.anyrem.jss_addresses.service;

import org.anyrem.jss_addresses.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAll();
    Address findById(Long id);
    List<Address> findByIds(Long[] ids);

    Address save(Address address);
}
