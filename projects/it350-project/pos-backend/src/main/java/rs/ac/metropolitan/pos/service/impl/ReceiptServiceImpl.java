package rs.ac.metropolitan.pos.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.repository.ReceiptRepository;
import rs.ac.metropolitan.pos.service.ReceiptService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class ReceiptServiceImpl implements ReceiptService {
	private final ReceiptRepository receiptRepository;

	@Override
	public List<Receipt> findAll() {
		return receiptRepository.findAll();
	}

	@Override
	public Receipt findById(Integer receiptId) {
		return receiptRepository.findById(receiptId)
				.orElseThrow(() -> new NoSuchElementException("ReceiptService.notFound"));
	}

	@Override
	public Receipt save(Receipt receipt) {
		return receiptRepository.save(receipt);
	}

	@Override
	public Receipt update(Receipt receipt) {
		return receiptRepository.save(receipt);
	}

	@Override
	public void deleteById(Integer receiptId) {
		receiptRepository.deleteById(receiptId);
	}


}