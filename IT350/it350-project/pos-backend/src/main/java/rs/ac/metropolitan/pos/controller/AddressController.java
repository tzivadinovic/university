package rs.ac.metropolitan.pos.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.service.*;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
	private final AddressService addressService;

	@GetMapping
	public ResponseEntity<List<Address>> getAll() {
		return ResponseEntity.ok(addressService.findAll());
	}

	@GetMapping("/{addressId}")
	public ResponseEntity<Address> getById(@PathVariable Integer addressId) {
		return ResponseEntity.ok(addressService.findById(addressId));
	}

	@PostMapping
	public ResponseEntity<Address> save(@RequestBody Address address) {
		return ResponseEntity.ok(addressService.save(address));
	}

	@PutMapping
	public ResponseEntity<Address> update(@RequestBody Address address) {
		return ResponseEntity.ok(addressService.update(address));
	}

	@DeleteMapping("/{addressId}")
	public void deleteById(@PathVariable Integer addressId) {
		addressService.deleteById(addressId);
	}

}

