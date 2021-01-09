package rs.ac.metropolitan.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.pos.entity.Receipt;

@Repository
public  interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

}