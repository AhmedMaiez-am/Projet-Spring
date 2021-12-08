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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Produit")
public class Produit {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit; // Clé primaire
	private String code;
	private String libelle;
	private Float prixUnitaire;
	
	
	@OneToOne
	private DetailProduit detailProduit;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
    private List<detailFacture> detailfactp ;
	
	@ManyToOne
    @JoinColumn(name="idRayon")
    private Rayon rayon;
	
	@ManyToOne
    @JoinColumn(name="idStock")
    private Stock stock;
	
	@ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="produit_fournisseur", joinColumns=@JoinColumn(name="idFournisseur"),
    inverseJoinColumns=@JoinColumn(name="idProduit"))//@JoinTable is used to map Join table in database
	private List<Fournisseur> fournisseurs;

	
}
