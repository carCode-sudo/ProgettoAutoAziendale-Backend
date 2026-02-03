package com.progettoAuto.prenotazione.service;

import java.util.List;
import java.util.Optional;

import com.progettoAuto.prenotazione.model.Utente;
import com.progettoAuto.prenotazione.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progettoAuto.prenotazione.Dto.PrenotazioneDto;
import com.progettoAuto.prenotazione.Mapper.Mapper;
import com.progettoAuto.prenotazione.model.Auto;
import com.progettoAuto.prenotazione.model.Prenotazione;
import com.progettoAuto.prenotazione.repository.AutoRepository;
import com.progettoAuto.prenotazione.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	
	
	@Autowired
	private static PrenotazioneRepository prenotazioneRepository;
	@Autowired
	private static AutoRepository  autoRepository;
	@Autowired
	private Mapper mapper;

	private static UtenteRepository utenteRepository;

	public static Prenotazione effettuaPrenotazione(Prenotazione prenotazione, Utente utente) {

		Auto auto = autoRepository.findBySeriale(prenotazione.getAuto().getSeriale()).orElseThrow(()-> new RuntimeException("Auto non trovata"));

		int collisioni = prenotazioneRepository.trovaSovrapposizioni(prenotazione.getDataInizio(), prenotazione.getDataFine(), auto.getSeriale());

		if(collisioni > 0){
			throw new RuntimeException("l'auto e gia selezionata nel periodo selezionato");
		}
		prenotazione.setUtente(utente);
		prenotazione.setAuto(auto);
		return  prenotazioneRepository.save(prenotazione);

//		Prenotazione prenotazioneEntity=mapper.convertDtoToEntity(prenotazione);
//		List<Prenotazione> result = prenotazioneRepository.findByAuto_Seriale( prenotazioneEntity.getAuto().getSeriale());
//		if(result.isEmpty()) {
//			return !result.isEmpty();
//		}
//		else
//		{
//			boolean risul=false;
//
//				if(prenotazioneRepository.trovaData(
//						prenotazione.getDataInizio(),
//						prenotazione.getDataFine(),
//						prenotazione.getSeriale())
//						> 0)
//				{risul=true;}
//			return risul;
//		}
		
	}
	
	public boolean insertPrenotazione( PrenotazioneDto _prenotazione) {
		//Optional<Auto> auto = autoRepository.findBySeriale(_prenotazione.getSeriale());
		Prenotazione prenotazione=mapper.convertDtoToEntity(_prenotazione);
		prenotazioneRepository.save(prenotazione);
		return true;
	}

	public List<Prenotazione> getAllPrenotazioni(String codiceFiscale){
		
		System.out.println("stampa lista prenotazioneeeeeeeeeeeeeeeeeeeeeee");
		return prenotazioneRepository.findByUtente_CodiceFiscale(codiceFiscale);
		}
	
	
	
	

}
