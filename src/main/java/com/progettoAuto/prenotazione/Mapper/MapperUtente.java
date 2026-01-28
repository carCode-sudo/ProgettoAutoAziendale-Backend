package com.progettoAuto.prenotazione.Mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.progettoAuto.prenotazione.Dto.UtenteDto;
import com.progettoAuto.prenotazione.model.Utente;
import com.progettoAuto.prenotazione.repository.UtenteRepository;


@Component
public class MapperUtente {
	
	
	@Autowired
	private UtenteRepository utenteRepo;
	
	
public UtenteDto convertEntityToDto(Utente _utente) {
		
	UtenteDto utente=new UtenteDto();
		
	utente.setCodiceFiscale(_utente.getCodiceFiscale());
	utente.setNome(_utente.getNome());
	utente.setCognome(_utente.getCognome());
	utente.setLivello(1);
	
		return utente;
		
	}
	
public Utente convertDtoToEntity(UtenteDto _utente) {
	
	Optional<Utente> p= utenteRepo.findByCodiceFiscale(_utente.getCodiceFiscale());
	
	
	Utente utente = new Utente();
	
	utente.setNome(_utente.getNome());
	utente.setCognome(_utente.getCognome());
	utente.setCodiceFiscale(_utente.getCodiceFiscale());
	
	if(p.isPresent()) {
		
		utente.setLivello(p.get().getLivello());
	}else {
		utente.setLivello(1);
	}
	
	
	
	return utente;
}


	
	
	
	
}
