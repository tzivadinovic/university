package rs.ac.metropolitan.pos.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.service.*;

@RestController
@RequestMapping("/receipts")
@RequiredArgsConstructor
public class ReceiptController {
	private final ReceiptService receiptService;

	@GetMapping
	public ResponseEntity<List<Receipt>> getAll() {
		return ResponseEntity.ok(receiptService.findAll());
	}

	@GetMapping("/{receiptId}")
	public ResponseEntity<Receipt> getById(@PathVariable Integer receiptId) {
		return ResponseEntity.ok(receiptService.findById(receiptId));
	}

	@PostMapping
	public ResponseEntity<Receipt> save(@RequestBody Receipt receipt) {
		return ResponseEntity.ok(receiptService.save(receipt));
	}

	@PutMapping
	public ResponseEntity<Receipt> update(@RequestBody Receipt receipt) {
		return ResponseEntity.ok(receiptService.update(receipt));
	}

	@DeleteMapping("/{receiptId}")
	public void deleteById(@PathVariable Integer receiptId) {
		receiptService.deleteById(receiptId);
	}

}

