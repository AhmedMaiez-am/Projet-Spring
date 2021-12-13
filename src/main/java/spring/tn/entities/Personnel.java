package spring.tn.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import spring.tn.enume.Poste;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Personnel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String nom;

	String prenom;
	
	int age;
	
	@Temporal(TemporalType.DATE)
	Date dateDeRecrutement;
	
	String login;
	
	String password;
	
	Poste poste;
	
	@OneToOne(mappedBy="personnel")
	private Zone zone;
	
	@ManyToOne
	Zone zoneDePersonnel;

}
