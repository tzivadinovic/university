package rs.ac.metropolitan.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "supplier")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Supplier extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "supplier_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "contact_person")
	private String contactPerson;
	
}