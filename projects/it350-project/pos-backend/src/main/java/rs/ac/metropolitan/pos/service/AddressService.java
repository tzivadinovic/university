package rs.ac.metropolitan.pos.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.pos.entity.*;

public  interface AddressService {

	List<Address> findAll();

	Address save(Address address);

	Address update(Address address);

	Address findById(Integer addressId);

	void deleteById(Integer addressId);

}