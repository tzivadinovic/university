package rs.ac.metropolitan.pos.entity;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_type")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductType extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "product_type_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	
}