package rs.ac.metropolitan.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.pos.entity.Supplier;

@Repository
public  interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}