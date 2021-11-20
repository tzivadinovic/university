package rs.ac.metropolitan.pos.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.pos.entity.*;

public  interface ProductService {

	List<Product> findAll();

	Product save(Product product);

	Product update(Product product);

	Product findById(Integer productId);

	void deleteById(Integer productId);

}