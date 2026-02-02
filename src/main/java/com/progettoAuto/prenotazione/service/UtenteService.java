package com.progettoAuto.prenotazione.service;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.progettoAuto.prenotazione.Dto.UtenteDto;
import com.progettoAuto.prenotazione.model.Utente;

public interface UtenteService{

	public UtenteDto saveUtente(UtenteDto _utente);
	
	public List<Utente> getAllUtente();
	
	public Utente getSingleUtente(@PathVariable Integer id);
	
	public Utente utenteUpdate(UtenteDto _utente);
	
	public Optional<Utente> getUtente(Utente utente);
	
}
