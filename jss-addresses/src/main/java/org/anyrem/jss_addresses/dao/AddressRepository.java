package org.anyrem.jss_addresses.dao;

import org.anyrem.jss_addresses.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
