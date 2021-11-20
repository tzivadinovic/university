package rs.ac.metropolitan.pos.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.service.*;

@RestController
@RequestMapping("/cash-registers")
@RequiredArgsConstructor
public class CashRegisterController {
	private final CashRegisterService cashRegisterService;

	@GetMapping
	public ResponseEntity<List<CashRegister>> getAll() {
		return ResponseEntity.ok(cashRegisterService.findAll());
	}

	@GetMapping("/{cashRegisterId}")
	public ResponseEntity<CashRegister> getById(@PathVariable Integer cashRegisterId) {
		return ResponseEntity.ok(cashRegisterService.findById(cashRegisterId));
	}

	@PostMapping
	public ResponseEntity<CashRegister> save(@RequestBody CashRegister cashRegister) {
		return ResponseEntity.ok(cashRegisterService.save(cashRegister));
	}

	@PutMapping
	public ResponseEntity<CashRegister> update(@RequestBody CashRegister cashRegister) {
		return ResponseEntity.ok(cashRegisterService.update(cashRegister));
	}

	@DeleteMapping("/{cashRegisterId}")
	public void deleteById(@PathVariable Integer cashRegisterId) {
		cashRegisterService.deleteById(cashRegisterId);
	}

}

