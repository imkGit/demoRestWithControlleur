package com.restExemple.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity
@Table(name = "AIRCOMPAGNIE")
public class AirCompagnie {
	
	
	@Id 
	@GeneratedValue 
	@Column(name = "Id", nullable = false)
	private Long id;
	
	@Column(name = "nomCompagnie", nullable = false)
	private String nomCompagnie;
	
	@DateTimeFormat
	@Column(name = "dateDebut")
	private LocalDate dateDebut;
	
	@DateTimeFormat
	@Column(name = "dateFin")
	private LocalDate dateFin;
	
	@Column(name = "aeroportDepart")
	private String aeroportDepart;
	
	@Column(name = "aeroportDest")
	private String aeroportDest;
	
	@Column(name = "prix")
	private BigDecimal prix;
	
	
	public AirCompagnie(String nomCompagnie, LocalDate dateDebut, LocalDate dateFin, String aeroportDepart,
			String aeroportDest, BigDecimal prix) {
		super();
		this.nomCompagnie = nomCompagnie;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.aeroportDepart = aeroportDepart;
		this.aeroportDest = aeroportDest;
		this.prix = prix;
	}
	


}
