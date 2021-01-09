package rs.ac.metropolitan.pos.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.repository.ProcurementRepository;
import rs.ac.metropolitan.pos.service.ProcurementService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class ProcurementServiceImpl implements ProcurementService {
	private final ProcurementRepository procurementRepository;

	@Override
	public List<Procurement> findAll() {
		return procurementRepository.findAll();
	}

	@Override
	public Procurement findById(Integer procurementId) {
		return procurementRepository.findById(procurementId)
				.orElseThrow(() -> new NoSuchElementException("ProcurementService.notFound"));
	}

	@Override
	public Procurement save(Procurement procurement) {
		return procurementRepository.save(procurement);
	}

	@Override
	public Procurement update(Procurement procurement) {
		return procurementRepository.save(procurement);
	}

	@Override
	public void deleteById(Integer procurementId) {
		procurementRepository.deleteById(procurementId);
	}


}