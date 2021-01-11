package rs.ac.metropolitan.pos.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.repository.SupplierRepository;
import rs.ac.metropolitan.pos.service.SupplierService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class SupplierServiceImpl implements SupplierService {
	private final SupplierRepository supplierRepository;

	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier findById(Integer supplierId) {
		return supplierRepository.findById(supplierId)
				.orElseThrow(() -> new NoSuchElementException("SupplierService.notFound"));
	}

	@Override
	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier update(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public void deleteById(Integer supplierId) {
		supplierRepository.deleteById(supplierId);
	}


}