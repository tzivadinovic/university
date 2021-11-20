package rs.ac.metropolitan.pos.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.pos.entity.*;

public  interface CashRegisterService {

	List<CashRegister> findAll();

	CashRegister save(CashRegister cashRegister);

	CashRegister update(CashRegister cashRegister);

	CashRegister findById(Integer cashRegisterId);

	void deleteById(Integer cashRegisterId);

}