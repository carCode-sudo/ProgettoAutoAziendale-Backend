package com.progettoAuto.prenotazione.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progettoAuto.prenotazione.Dto.UtenteDto;
import com.progettoAuto.prenotazione.Mapper.MapperUtente;
import com.progettoAuto.prenotazione.model.Utente;
import com.progettoAuto.prenotazione.service.UtenteService;

@RestController
@RequestMapping("/utente")
public class utenteController {

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private MapperUtente mapperUtente;
	
	
		@PostMapping("/add")
		public ResponseEntity<String> add(@RequestBody UtenteDto _utente) {
			_utente.setLivello(1);
			
			Utente utente= new Utente();	
			
			utente.setCodiceFiscale(_utente.getCodiceFiscale());
			utente.setCognome(_utente.getCognome());
			utente.setNome(_utente.getNome());
			//Utente utente1=mapperUtente.convertDtoToEntity(_utente);
			
			if(utenteService.getUtente(utente).isPresent()) {
				
				return ResponseEntity.badRequest().build();
			}
			utenteService.saveUtente(_utente);
			
		return ResponseEntity.ok().build();
		}
		@GetMapping("/getAll")
		public List<Utente> getAllUtente(){
			return utenteService.getAllUtente();
		}
		
		
		@GetMapping("/get/{id}")
		public Utente getSingleUtente(@PathVariable Integer id) {
			
			return utenteService.getSingleUtente(id);
		}
		
		@PatchMapping("/update")	
		public Utente updateUtente(@RequestBody UtenteDto utente) {
			
			
			return utenteService.utenteUpdate(utente);
			
		}
		
		@PostMapping("/verificaUtente")	
		public ResponseEntity<Optional<Utente>> verificaLogin(@RequestBody Utente utente) {
			
			
			Optional<Utente>ris =utenteService.getUtente(utente);
			
			if(ris.isPresent()) {
				
				return ResponseEntity.ok(ris);
				
			}
			return ResponseEntity.badRequest().body(ris);	
					
					
			
		}
		


}
