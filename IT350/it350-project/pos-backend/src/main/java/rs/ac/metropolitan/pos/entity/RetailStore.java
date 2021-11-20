package rs.ac.metropolitan.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "retail_store")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class RetailStore extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "retail_store_id")
	private Integer id;
	@Column(name = "tax_id")
	private Integer taxId;
	@Column(name = "name")
	private String name;
	@Column(name = "work_code")
	private String workCode;
	
}