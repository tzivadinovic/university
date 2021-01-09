package rs.ac.metropolitan.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "delivery")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Delivery extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "delivery_id")
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "receipt_id")
	private Integer receiptId;
	@Column(name = "delivery_number")
	private String deliveryNumber;
	@Column(name = "products_number")
	private Integer productsNumber;
	@Column(name = "tax")
	private Double tax;
	
}