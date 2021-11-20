package rs.ac.metropolitan.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "procurement")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Procurement extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "procurement_id")
	private Integer id;
	@Column(name = "retail_store_id")
	private Integer retailStoreId;
	@Column(name = "procurement_number")
	private String procurementNumber;
	@Column(name = "products_number")
	private Integer productsNumber;
	
}