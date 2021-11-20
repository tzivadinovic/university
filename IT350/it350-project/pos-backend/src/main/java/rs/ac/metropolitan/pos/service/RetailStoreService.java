package rs.ac.metropolitan.pos.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.pos.entity.*;

public  interface RetailStoreService {

	List<RetailStore> findAll();

	RetailStore save(RetailStore retailStore);

	RetailStore update(RetailStore retailStore);

	RetailStore findById(Integer retailStoreId);

	void deleteById(Integer retailStoreId);

}