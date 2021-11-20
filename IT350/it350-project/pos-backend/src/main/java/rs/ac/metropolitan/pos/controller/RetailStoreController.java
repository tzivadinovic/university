package rs.ac.metropolitan.pos.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.service.*;

@RestController
@RequestMapping("/retail-stores")
@RequiredArgsConstructor
public class RetailStoreController {
	private final RetailStoreService retailStoreService;

	@GetMapping
	public ResponseEntity<List<RetailStore>> getAll() {
		return ResponseEntity.ok(retailStoreService.findAll());
	}

	@GetMapping("/{retailStoreId}")
	public ResponseEntity<RetailStore> getById(@PathVariable Integer retailStoreId) {
		return ResponseEntity.ok(retailStoreService.findById(retailStoreId));
	}

	@PostMapping
	public ResponseEntity<RetailStore> save(@RequestBody RetailStore retailStore) {
		return ResponseEntity.ok(retailStoreService.save(retailStore));
	}

	@PutMapping
	public ResponseEntity<RetailStore> update(@RequestBody RetailStore retailStore) {
		return ResponseEntity.ok(retailStoreService.update(retailStore));
	}

	@DeleteMapping("/{retailStoreId}")
	public void deleteById(@PathVariable Integer retailStoreId) {
		retailStoreService.deleteById(retailStoreId);
	}

}

