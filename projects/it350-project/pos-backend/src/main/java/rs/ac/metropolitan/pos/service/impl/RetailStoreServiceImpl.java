package rs.ac.metropolitan.pos.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.repository.RetailStoreRepository;
import rs.ac.metropolitan.pos.service.RetailStoreService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class RetailStoreServiceImpl implements RetailStoreService {
	private final RetailStoreRepository retailStoreRepository;

	@Override
	public List<RetailStore> findAll() {
		return retailStoreRepository.findAll();
	}

	@Override
	public RetailStore findById(Integer retailStoreId) {
		return retailStoreRepository.findById(retailStoreId)
				.orElseThrow(() -> new NoSuchElementException("RetailStoreService.notFound"));
	}

	@Override
	public RetailStore save(RetailStore retailStore) {
		return retailStoreRepository.save(retailStore);
	}

	@Override
	public RetailStore update(RetailStore retailStore) {
		return retailStoreRepository.save(retailStore);
	}

	@Override
	public void deleteById(Integer retailStoreId) {
		retailStoreRepository.deleteById(retailStoreId);
	}


}