package rs.ac.metropolitan.pos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.pos.entity.DeliveryProduct;
import rs.ac.metropolitan.pos.service.DeliveryProductService;

import java.util.List;

@RestController
@RequestMapping("/deliveryproducts")
@RequiredArgsConstructor
public class DeliveryProductController {
    private final DeliveryProductService deliveryProductService;

    @GetMapping
    public ResponseEntity<List<DeliveryProduct>> getAll() {
        return ResponseEntity.ok(deliveryProductService.findAll());
    }

    @GetMapping("/{deliveryProductId}")
    public ResponseEntity<DeliveryProduct> getById(@PathVariable Integer deliveryProductId) {
        return ResponseEntity.ok(deliveryProductService.findById(deliveryProductId));
    }

    @PostMapping
    public ResponseEntity<DeliveryProduct> save(@RequestBody DeliveryProduct deliveryProduct) {
        return ResponseEntity.ok(deliveryProductService.save(deliveryProduct));
    }

    @PutMapping
    public ResponseEntity<DeliveryProduct> update(@RequestBody DeliveryProduct deliveryProduct) {
        return ResponseEntity.ok(deliveryProductService.update(deliveryProduct));
    }

    @DeleteMapping("/{deliveryProductId}")
    public void deleteById(@PathVariable Integer deliveryProductId) {
        deliveryProductService.deleteById(deliveryProductId);
    }
}
