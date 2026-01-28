package com.progettoAuto.prenotazione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progettoAuto.prenotazione.Dto.PrenotazioneDto;
import com.progettoAuto.prenotazione.Dto.UtenteDto;
import com.progettoAuto.prenotazione.Mapper.Mapper;
import com.progettoAuto.prenotazione.model.Prenotazione;
import com.progettoAuto.prenotazione.service.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService prenotazioneService;
	@Autowired
	private Mapper mapper;

	@PostMapping("/verifica")
	public ResponseEntity<PrenotazioneDto> verifica( @RequestBody PrenotazioneDto _prenotazione){
		boolean exist = prenotazioneService.prenotazioneExists( _prenotazione);
		if(exist) {
			
			System.out.println("stampa exsist"+exist);
			return ResponseEntity.ok(_prenotazione);
		}else {
			inserisci(_prenotazione);
			return ResponseEntity.accepted().body(_prenotazione);
		}
	}
	public PrenotazioneDto inserisci( PrenotazioneDto _prenotazione){
		prenotazioneService.insertPrenotazione(_prenotazione);
		return _prenotazione;
	}

	@PostMapping("/getAll")
public  ResponseEntity<List<PrenotazioneDto>> getAllPrenotazioni(@RequestBody UtenteDto utente) {

		List<Prenotazione> prenotazione=prenotazioneService.getAllPrenotazioni(utente.getCodiceFiscale());
		System.out.println("stampa lista prenotazioneeeeeeeeeeeeeeeeeeeeeee"+prenotazione);
		List<PrenotazioneDto> _prenotazione =mapper.convertEntityToDtoList(prenotazione);
		return ResponseEntity.ok(_prenotazione);
	}
	
	
	

}
