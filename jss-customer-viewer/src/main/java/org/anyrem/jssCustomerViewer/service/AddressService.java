package org.anyrem.jssCustomerViewer.service;

import org.anyrem.jssCustomerViewer.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    public List<Address> getAddresses();

    public void saveAddress(Address address);

    public Optional<Address> getAddress(Long theId);

    public void deleteAddress(Long theId);

}
