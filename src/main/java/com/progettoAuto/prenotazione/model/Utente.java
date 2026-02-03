package com.progettoAuto.prenotazione.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utente {
	
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Id
	@Column(name="codice_fiscale", nullable = false)
	private String codiceFiscale;
	
	private String nome;
	private String  cognome;	
	private int livello;
	
	



	
}
