package rs.ac.metropolitan.pos.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.repository.ProductTypeRepository;
import rs.ac.metropolitan.pos.service.ProductTypeService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class ProductTypeServiceImpl implements ProductTypeService {
	private final ProductTypeRepository productTypeRepository;

	@Override
	public List<ProductType> findAll() {
		return productTypeRepository.findAll();
	}

	@Override
	public ProductType findById(Integer productTypeId) {
		return productTypeRepository.findById(productTypeId)
				.orElseThrow(() -> new NoSuchElementException("ProductTypeService.notFound"));
	}

	@Override
	public ProductType save(ProductType productType) {
		return productTypeRepository.save(productType);
	}

	@Override
	public ProductType update(ProductType productType) {
		return productTypeRepository.save(productType);
	}

	@Override
	public void deleteById(Integer productTypeId) {
		productTypeRepository.deleteById(productTypeId);
	}


}