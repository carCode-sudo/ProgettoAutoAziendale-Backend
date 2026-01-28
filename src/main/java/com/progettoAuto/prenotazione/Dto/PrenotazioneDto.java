package com.progettoAuto.prenotazione.Dto;

import java.time.LocalDate;

import lombok.Data;




@Data
public class PrenotazioneDto {
	
	
	
	
	private int id;
	private String codiceFiscale;
	private String seriale;	
	private LocalDate dataInizio;
	private LocalDate  dataFine;
	
	
	

}
