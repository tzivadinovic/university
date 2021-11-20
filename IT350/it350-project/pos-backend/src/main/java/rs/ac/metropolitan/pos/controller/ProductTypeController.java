package rs.ac.metropolitan.pos.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.pos.entity.*;
import rs.ac.metropolitan.pos.service.*;

@RestController
@RequestMapping("/product-types")
@RequiredArgsConstructor
public class ProductTypeController {
	private final ProductTypeService productTypeService;

	@GetMapping
	public ResponseEntity<List<ProductType>> getAll() {
		return ResponseEntity.ok(productTypeService.findAll());
	}

	@GetMapping("/{productTypeId}")
	public ResponseEntity<ProductType> getById(@PathVariable Integer productTypeId) {
		return ResponseEntity.ok(productTypeService.findById(productTypeId));
	}

	@PostMapping
	public ResponseEntity<ProductType> save(@RequestBody ProductType productType) {
		return ResponseEntity.ok(productTypeService.save(productType));
	}

	@PutMapping
	public ResponseEntity<ProductType> update(@RequestBody ProductType productType) {
		return ResponseEntity.ok(productTypeService.update(productType));
	}

	@DeleteMapping("/{productTypeId}")
	public void deleteById(@PathVariable Integer productTypeId) {
		productTypeService.deleteById(productTypeId);
	}

}

