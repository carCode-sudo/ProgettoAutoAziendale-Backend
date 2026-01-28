package com.progettoAuto.prenotazione.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progettoAuto.prenotazione.Dto.UtenteDto;
import com.progettoAuto.prenotazione.Mapper.MapperUtente;
import com.progettoAuto.prenotazione.model.Utente;
import com.progettoAuto.prenotazione.repository.UtenteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UtenteServiceImplementation implements UtenteService {

	
		
	@Autowired
	private UtenteRepository  utenteRepository;
	@Autowired
	private MapperUtente mapperUtente;
	
	@Override
	public UtenteDto saveUtente(UtenteDto _utente) {	
		
		Utente utente= new Utente();
	
		utente.setId(_utente.getId());
		utente.setCodiceFiscale(_utente.getCodiceFiscale());
		utente.setCognome(_utente.getCognome());
		utente.setNome(_utente.getNome());
		utente.setLivello(_utente.getLivello());
		
		Utente utente1=mapperUtente.convertDtoToEntity(_utente);
		utenteRepository.save(utente1);
		return _utente;
	}
	@Override
	public List<Utente> getAllUtente(){
	return (List<Utente>) utenteRepository.findAll();
	}
	public Utente getSingleUtente( Integer id) {
	return utenteRepository.findById(id).get();
	}
	public Utente utenteUpdate(UtenteDto _utente) {
		Utente utente= new Utente();

		utente.setId(_utente.getId());
		utente.setCodiceFiscale(_utente.getCodiceFiscale());
		utente.setCognome(_utente.getCognome());
		utente.setNome(_utente.getNome());
		utente.setLivello(_utente.getLivello());

		Optional<Utente> utenteSave = utenteRepository.findById(utente.getId());
		
    	utente.setCodiceFiscale(utenteSave.get().getCodiceFiscale());
    	utente.setId(utenteSave.get().getId());
		try {
			utenteRepository.save(utente);	
			return utente;
		}
		catch(Exception e) {
			return utente;
		}
	}
	
	public Optional<Utente> getUtente(Utente utente) {

		Optional<Utente> persistedPerson =  utenteRepository.findById(utente.getCodiceFiscale());
		return persistedPerson;
	}
	
}
