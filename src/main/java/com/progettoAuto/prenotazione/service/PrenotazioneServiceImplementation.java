package com.progettoAuto.prenotazione.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.progettoAuto.prenotazione.model.Utente;
import com.progettoAuto.prenotazione.repository.UtenteRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progettoAuto.prenotazione.Dto.PrenotazioneDto;
import com.progettoAuto.prenotazione.Mapper.Mapper;
import com.progettoAuto.prenotazione.model.Auto;
import com.progettoAuto.prenotazione.model.Prenotazione;
import com.progettoAuto.prenotazione.repository.PrenotazioneRepository;
@Slf4j
@Service
public class PrenotazioneServiceImplementation implements PrenotazioneService {


	@Autowired
	private  PrenotazioneRepository prenotazioneRepository;
	@Autowired
	private  AutoService  autoService;
	@Autowired
	private Mapper mapper;

	private static UtenteRepository utenteRepository;

	public boolean effettuaPrenotazione(Prenotazione prenotazione, Utente utente) {

		Optional<Auto> auto = autoService.findAutoBySeriale(prenotazione.getAuto().getSeriale());
		int collisioni = prenotazioneRepository.trovaSovrapposizioni(prenotazione.getDataInizio(), prenotazione.getDataFine(), auto.get().getSeriale());
		if(collisioni > 0){
			return false;
		}
		prenotazione.setUtente(utente);
		prenotazione.setAuto(auto.get());
		try {
			prenotazioneRepository.save(prenotazione);
			return  true;

		}catch (Exception e){return false;}



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
