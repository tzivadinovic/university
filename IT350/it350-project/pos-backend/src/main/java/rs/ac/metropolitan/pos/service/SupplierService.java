package rs.ac.metropolitan.pos.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.pos.entity.*;

public  interface SupplierService {

	List<Supplier> findAll();

	Supplier save(Supplier supplier);

	Supplier update(Supplier supplier);

	Supplier findById(Integer supplierId);

	void deleteById(Integer supplierId);

}