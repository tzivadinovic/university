package rs.ac.metropolitan.pos.service;

import rs.ac.metropolitan.pos.entity.DeliveryProduct;

import java.util.List;

public interface DeliveryProductService {
    List<DeliveryProduct> findAll();

    DeliveryProduct save(DeliveryProduct deliveryProduct);

    DeliveryProduct update(DeliveryProduct deliveryProduct);

    DeliveryProduct findById(Integer deliveryProductId);

    void deleteById(Integer deliveryProductId);
}
