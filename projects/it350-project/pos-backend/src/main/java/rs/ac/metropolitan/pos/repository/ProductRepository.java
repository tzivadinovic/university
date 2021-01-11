package rs.ac.metropolitan.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.pos.entity.Product;

@Repository
public  interface ProductRepository extends JpaRepository<Product, Integer> {

}