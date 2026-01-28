package com.progettoAuto.prenotazione.Dto;

import java.time.LocalDate;

import lombok.Data;


@Data
public class AutoDto {
	
	
	
	private int id;
	private String nome;
	private String  marca;
	private String seriale;
	private LocalDate dataInizio;
	private LocalDate  dataFine;
	private int livello;

}
