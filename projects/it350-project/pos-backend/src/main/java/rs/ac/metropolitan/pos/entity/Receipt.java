package rs.ac.metropolitan.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "receipt")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Receipt extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "receipt_id")
	private Integer id;
	@Column(name = "delivery_id")
	private Integer deliveryId;
	@Column(name = "cash_register_id")
	private Integer cashRegisterId;
	@Column(name = "total_price")
	private Double totalPrice;
	
}