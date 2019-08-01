package org.anyrem.jss_addresses.service;

import org.anyrem.jss_addresses.dao.AddressRepository;
import org.anyrem.jss_addresses.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> findAll(){
        return addressRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Address findById(Long id) {

        Optional<Address> tempAddr = addressRepository.findById(id);
        if (tempAddr.isPresent()) {
            return tempAddr.get();
        } else {
            throw new RuntimeException("ID not found");
        }
    }

    @Override
    public List<Address> findByIds(Long[] ids) {

        List<Address> addressesList = new ArrayList<>();

        Arrays.stream(ids).forEach(id -> {
            Optional<Address> temp = addressRepository.findById(id);
            if (temp.isPresent()) {
                addressesList.add(temp.get());
            }
        });
        return addressesList;
    }

    @Override
    public Address save(Address address) {

        if (!isPresent(address)) {
            return addressRepository.save(address);
        } else {
            throw new RuntimeException("Address already exist");
        }

    }

    private boolean isPresent(Address address) {

        if (addressRepository.findAll().contains(address)) {
            return true;
        } else {
            return false;
        }
    }
}
