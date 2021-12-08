package com.esprit.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "detailProduit")
public class DetailProduit {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailProduit")
	private Long idDetailProduit; // Clé primaire
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
	private Date dateDernièreModification;
	@Enumerated(EnumType.STRING)
	CategorieProduit categorieProduit; 
	
	@OneToOne(mappedBy="detailProduit")
	@JsonIgnore
	private Produit produit;
	
	
	
	public Long getIdDetailProduit() {
		return idDetailProduit;
	}
	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateDernièreModification() {
		return dateDernièreModification;
	}
	public void setDateDernièreModification(Date dateDernièreModification) {
		this.dateDernièreModification = dateDernièreModification;
	}
	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}
	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	public DetailProduit(Long idProduit, Date date, Date date2,  CategorieProduit cat) {
		
	}
	public DetailProduit(Date dateCreation, Date dateDernièreModification, CategorieProduit categorieProduit) {
		super();
		this.dateCreation = dateCreation;
		this.dateDernièreModification = dateDernièreModification;
		this.categorieProduit = categorieProduit;
	};
}
