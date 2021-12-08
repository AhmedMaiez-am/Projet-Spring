package com.esprit.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.esprit.service.DetailFacture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Facture")
public class Facture {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private Long idFacture; // Clé primaire
	private Float montantRemise;
	private Float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	private Boolean active;
	@ManyToOne
    @JoinColumn(name="idClient")
    private Client client;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private List<detailFacture> Detailfacture;
	

	
}
