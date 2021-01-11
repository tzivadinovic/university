package rs.ac.metropolitan.pos.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "role")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Role extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "role_id")
	private Integer id;
	@Column(name = "role")
	private String role;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> user;
	
}