package rs.ac.metropolitan.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Product extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "product_id")
	private Integer id;
	@JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id")
	@ManyToOne
	private ProductType productType;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Double price;
	@Column(name = "stock")
	private Integer stock;
	
}