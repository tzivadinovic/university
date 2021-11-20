package rs.ac.metropolitan.pos.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.pos.entity.*;

public  interface ProductTypeService {

	List<ProductType> findAll();

	ProductType save(ProductType productType);

	ProductType update(ProductType productType);

	ProductType findById(Integer productTypeId);

	void deleteById(Integer productTypeId);

}