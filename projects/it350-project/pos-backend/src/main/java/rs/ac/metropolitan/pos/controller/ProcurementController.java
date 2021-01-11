package rs.ac.metropolitan.pos.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.service.*;

@RestController
@RequestMapping("/procurements")
@RequiredArgsConstructor
public class ProcurementController {
	private final ProcurementService procurementService;

	@GetMapping
	public ResponseEntity<List<Procurement>> getAll() {
		return ResponseEntity.ok(procurementService.findAll());
	}

	@GetMapping("/{procurementId}")
	public ResponseEntity<Procurement> getById(@PathVariable Integer procurementId) {
		return ResponseEntity.ok(procurementService.findById(procurementId));
	}

	@PostMapping
	public ResponseEntity<Procurement> save(@RequestBody Procurement procurement) {
		return ResponseEntity.ok(procurementService.save(procurement));
	}

	@PutMapping
	public ResponseEntity<Procurement> update(@RequestBody Procurement procurement) {
		return ResponseEntity.ok(procurementService.update(procurement));
	}

	@DeleteMapping("/{procurementId}")
	public void deleteById(@PathVariable Integer procurementId) {
		procurementService.deleteById(procurementId);
	}

}

