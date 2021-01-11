package rs.ac.metropolitan.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.metropolitan.pos.entity.DeliveryProduct;

public interface DeliveryProductRepository extends JpaRepository<DeliveryProduct, Integer> {
}
