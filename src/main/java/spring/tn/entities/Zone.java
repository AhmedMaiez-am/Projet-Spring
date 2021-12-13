package spring.tn.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Zone {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String ref;

	float dimension;
	
	@OneToOne
	private Personnel personnel;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="zoneDePersonnel")
	private Set<Personnel> personnels;
	
	@ManyToOne
	Parking parking;
	
	

}
