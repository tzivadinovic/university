package rs.ac.metropolitan.pos.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.pos.entity.*;

public  interface DeliveryService {

	List<Delivery> findAll();

	Delivery save(Delivery delivery);

	Delivery update(Delivery delivery);

	Delivery findById(Integer deliveryId);

	void deleteById(Integer deliveryId);

}