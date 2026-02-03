package com.progettoAuto.prenotazione.controller;

import java.util.List;

import com.progettoAuto.prenotazione.model.Utente;
import com.progettoAuto.prenotazione.service.AutoService;
import com.progettoAuto.prenotazione.service.UtenteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progettoAuto.prenotazione.Dto.PrenotazioneDto;
import com.progettoAuto.prenotazione.Dto.UtenteDto;
import com.progettoAuto.prenotazione.Mapper.Mapper;
import com.progettoAuto.prenotazione.model.Prenotazione;
import com.progettoAuto.prenotazione.service.PrenotazioneServiceImplementation;

@Slf4j
@RestController
@RequestMapping("/prenotazione")
@RequiredArgsConstructor
public class PrenotazioneController {

	@Autowired
	private PrenotazioneServiceImplementation prenotazioneService;
	@Autowired
	private Mapper mapper;
    @Autowired
    private UtenteService utenteService;
	@Autowired
	private AutoService autoService;


	@PostMapping("/crea")
	public ResponseEntity<?> creaPrenotazione(@RequestBody Prenotazione prenotazione,
											  @AuthenticationPrincipal Jwt jwt){
		try{
			Utente utenteLoggato = utenteService.sincronizzaUtente(jwt);
			if(prenotazioneService.effettuaPrenotazione(prenotazione , utenteLoggato)){
				return ResponseEntity.ok().body("Prenotazione effettuata");
			}

		}catch (Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.status(409).body("Prenotazione non disponibile ");
	}


//	@PostMapping("/verifica")
//	public ResponseEntity<PrenotazioneDto> verifica( @RequestBody PrenotazioneDto _prenotazione){
//		boolean exist = prenotazioneService.prenotazioneExists( _prenotazione);
//		if(exist) {
//
//			System.out.println("stampa exsist"+exist);
//			return ResponseEntity.ok(_prenotazione);
//		}else {
//			inserisci(_prenotazione);
//			return ResponseEntity.accepted().body(_prenotazione);
//		}
//	}
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
