package rs.ac.metropolitan.pos.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.repository.DeliveryRepository;
import rs.ac.metropolitan.pos.service.DeliveryService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class DeliveryServiceImpl implements DeliveryService {
	private final DeliveryRepository deliveryRepository;

	@Override
	public List<Delivery> findAll() {
		return deliveryRepository.findAll();
	}

	@Override
	public Delivery findById(Integer deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new NoSuchElementException("DeliveryService.notFound"));
	}

	@Override
	public Delivery save(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}

	@Override
	public Delivery update(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}

	@Override
	public void deleteById(Integer deliveryId) {
		deliveryRepository.deleteById(deliveryId);
	}


}