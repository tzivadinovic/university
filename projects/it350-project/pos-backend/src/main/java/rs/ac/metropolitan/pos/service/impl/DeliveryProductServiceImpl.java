package rs.ac.metropolitan.pos.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.pos.entity.DeliveryProduct;
import rs.ac.metropolitan.pos.repository.DeliveryProductRepository;
import rs.ac.metropolitan.pos.service.DeliveryProductService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class DeliveryProductServiceImpl implements DeliveryProductService {
    private final DeliveryProductRepository deliveryProductRepository;

    @Override
    public List<DeliveryProduct> findAll() {
        return deliveryProductRepository.findAll();
    }

    @Override
    public DeliveryProduct save(DeliveryProduct deliveryProduct) {
        return deliveryProductRepository.save(deliveryProduct);
    }

    @Override
    public DeliveryProduct update(DeliveryProduct deliveryProduct) {
        return deliveryProductRepository.save(deliveryProduct);
    }

    @Override
    public DeliveryProduct findById(Integer deliveryProductId) {
        return deliveryProductRepository.findById(deliveryProductId).orElseThrow(
                () -> new NoSuchElementException("DeliveryProductService.notFound"));
    }

    @Override
    public void deleteById(Integer deliveryProductId) {
        deliveryProductRepository.deleteById(deliveryProductId);
    }
}
