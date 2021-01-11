package rs.ac.metropolitan.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "address")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Address extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "address_id")
	private Integer id;
	@Column(name = "municipality")
	private String municipality;
	@Column(name = "city")
	private String city;
	@Column(name = "street_name")
	private String streetName;
	@Column(name = "street_number")
	private String streetNumber;
	
}