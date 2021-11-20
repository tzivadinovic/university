package rs.ac.metropolitan.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cash_register")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class CashRegister extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "cash_register_id")
	private Integer id;
	@Column(name = "retail_store_id")
	private Integer retailStoreId;
	
}