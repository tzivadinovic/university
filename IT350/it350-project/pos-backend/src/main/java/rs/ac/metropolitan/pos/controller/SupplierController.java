package rs.ac.metropolitan.pos.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.service.*;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {
	private final SupplierService supplierService;

	@GetMapping
	public ResponseEntity<List<Supplier>> getAll() {
		return ResponseEntity.ok(supplierService.findAll());
	}

	@GetMapping("/{supplierId}")
	public ResponseEntity<Supplier> getById(@PathVariable Integer supplierId) {
		return ResponseEntity.ok(supplierService.findById(supplierId));
	}

	@PostMapping
	public ResponseEntity<Supplier> save(@RequestBody Supplier supplier) {
		return ResponseEntity.ok(supplierService.save(supplier));
	}

	@PutMapping
	public ResponseEntity<Supplier> update(@RequestBody Supplier supplier) {
		return ResponseEntity.ok(supplierService.update(supplier));
	}

	@DeleteMapping("/{supplierId}")
	public void deleteById(@PathVariable Integer supplierId) {
		supplierService.deleteById(supplierId);
	}

}

