package com.progettoAuto.prenotazione.model;
import java.time.LocalDate;

import javax.persistence.*;

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
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="utente",referencedColumnName="codice_fiscale",insertable=true,updatable=true)
	private Utente utente;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="auto",referencedColumnName="seriale",insertable=true,updatable=true)
	private Auto auto;


	private LocalDate dataInizio;
	private LocalDate  dataFine;

}
