package com.progettoAuto.prenotazione.model;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "prenotazione")

public class Prenotazione {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="utente",referencedColumnName="codice_fiscale",insertable=true,updatable=true)
	private Utente utente;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="auto",referencedColumnName="seriale",insertable=true,updatable=true)
	private Auto auto;
	
	private LocalDate dataInizio;
	private LocalDate  dataFine;

}
