package rs.ac.metropolitan.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.pos.entity.Delivery;

@Repository
public  interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}