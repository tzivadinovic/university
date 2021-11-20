package rs.ac.metropolitan.pos.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.pos.entity.*;

public  interface ProcurementService {

	List<Procurement> findAll();

	Procurement save(Procurement procurement);

	Procurement update(Procurement procurement);

	Procurement findById(Integer procurementId);

	void deleteById(Integer procurementId);

}