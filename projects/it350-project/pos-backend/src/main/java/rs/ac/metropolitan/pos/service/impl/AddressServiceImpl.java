package rs.ac.metropolitan.pos.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.repository.AddressRepository;
import rs.ac.metropolitan.pos.service.AddressService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class AddressServiceImpl implements AddressService {
	private final AddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address findById(Integer addressId) {
		return addressRepository.findById(addressId)
				.orElseThrow(() -> new NoSuchElementException("AddressService.notFound"));
	}

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address update(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public void deleteById(Integer addressId) {
		addressRepository.deleteById(addressId);
	}


}