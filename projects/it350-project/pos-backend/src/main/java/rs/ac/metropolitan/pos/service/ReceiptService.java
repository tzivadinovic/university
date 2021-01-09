package rs.ac.metropolitan.pos.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.pos.entity.*;

public  interface ReceiptService {

	List<Receipt> findAll();

	Receipt save(Receipt receipt);

	Receipt update(Receipt receipt);

	Receipt findById(Integer receiptId);

	void deleteById(Integer receiptId);

}