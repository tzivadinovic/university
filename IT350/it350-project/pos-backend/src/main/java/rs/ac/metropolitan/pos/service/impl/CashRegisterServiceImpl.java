package rs.ac.metropolitan.pos.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.repository.CashRegisterRepository;
import rs.ac.metropolitan.pos.service.CashRegisterService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class CashRegisterServiceImpl implements CashRegisterService {
	private final CashRegisterRepository cashRegisterRepository;

	@Override
	public List<CashRegister> findAll() {
		return cashRegisterRepository.findAll();
	}

	@Override
	public CashRegister findById(Integer cashRegisterId) {
		return cashRegisterRepository.findById(cashRegisterId)
				.orElseThrow(() -> new NoSuchElementException("CashRegisterService.notFound"));
	}

	@Override
	public CashRegister save(CashRegister cashRegister) {
		return cashRegisterRepository.save(cashRegister);
	}

	@Override
	public CashRegister update(CashRegister cashRegister) {
		return cashRegisterRepository.save(cashRegister);
	}

	@Override
	public void deleteById(Integer cashRegisterId) {
		cashRegisterRepository.deleteById(cashRegisterId);
	}


}