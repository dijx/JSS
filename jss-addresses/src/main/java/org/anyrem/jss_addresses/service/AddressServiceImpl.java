package org.anyrem.jss_addresses.service;

import org.anyrem.jss_addresses.dao.AddressRepository;
import org.anyrem.jss_addresses.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> findAll(){
        return addressRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Address save(Address address) {
        addressRepository.save(address);
        return address;
    }
}
