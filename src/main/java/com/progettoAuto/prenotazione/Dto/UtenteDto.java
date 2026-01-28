package com.progettoAuto.prenotazione.Dto;

import javax.persistence.Id;

import lombok.Data;

@Data
public class UtenteDto {

	
	private int id;
	private String codiceFiscale;
	private String nome;
	private String  cognome;	
	private int livello;
	
	
	
}
