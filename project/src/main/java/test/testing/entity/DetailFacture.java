package test.testing.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class DetailFacture implements Serializable {
	/**
	 *
	 */
	static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idDetailFacture;

	int qte;

	float prixTotal;

	int pourcentageRemise;

	float montantRemise;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "factureId")
	Facture facture;

	@ManyToOne
	@JoinColumn(name = "produitId")
	Produit produit;
	

}

