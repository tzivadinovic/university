package rs.ac.metropolitan.pos.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.service.*;

@RestController
@RequestMapping("/deliveries")
@RequiredArgsConstructor
public class DeliveryController {
	private final DeliveryService deliveryService;

	@GetMapping
	public ResponseEntity<List<Delivery>> getAll() {
		return ResponseEntity.ok(deliveryService.findAll());
	}

	@GetMapping("/{deliveryId}")
	public ResponseEntity<Delivery> getById(@PathVariable Integer deliveryId) {
		return ResponseEntity.ok(deliveryService.findById(deliveryId));
	}

	@PostMapping
	public ResponseEntity<Delivery> save(@RequestBody Delivery delivery) {
		return ResponseEntity.ok(deliveryService.save(delivery));
	}

	@PutMapping
	public ResponseEntity<Delivery> update(@RequestBody Delivery delivery) {
		return ResponseEntity.ok(deliveryService.update(delivery));
	}

	@DeleteMapping("/{deliveryId}")
	public void deleteById(@PathVariable Integer deliveryId) {
		deliveryService.deleteById(deliveryId);
	}

}

