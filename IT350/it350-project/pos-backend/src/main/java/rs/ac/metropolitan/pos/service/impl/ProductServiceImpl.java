package rs.ac.metropolitan.pos.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.repository.ProductRepository;
import rs.ac.metropolitan.pos.service.ProductService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Integer productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new NoSuchElementException("ProductService.notFound"));
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product update(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteById(Integer productId) {
		productRepository.deleteById(productId);
	}


}