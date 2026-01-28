package com.progettoAuto.prenotazione.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.progettoAuto.prenotazione.Dto.PrenotazioneDto;
import com.progettoAuto.prenotazione.model.Auto;
import com.progettoAuto.prenotazione.model.Prenotazione;
import com.progettoAuto.prenotazione.model.Utente;
import com.progettoAuto.prenotazione.repository.AutoRepository;
import com.progettoAuto.prenotazione.repository.PrenotazioneRepository;
import com.progettoAuto.prenotazione.repository.UtenteRepository;

@Component
public class Mapper {
	
	@Autowired
	private AutoRepository  autoRepository;
	@Autowired
	private UtenteRepository  utenteRepository;
	@Autowired
	private PrenotazioneRepository prenotazioneRepository;
	
	
	
	
	public List<PrenotazioneDto> convertEntityToDtoList(List<Prenotazione> _prenotazione) {
		
		List<PrenotazioneDto> prenotazione= new ArrayList<PrenotazioneDto>();
		
		for(int i=0;i<_prenotazione.size();i++) {
			
			PrenotazioneDto p=new PrenotazioneDto();
			
			p.setCodiceFiscale(_prenotazione.get(i).getUtente().getCodiceFiscale());
			p.setSeriale(_prenotazione.get(i).getAuto().getSeriale());
			p.setDataInizio(_prenotazione.get(i).getDataInizio());
			p.setDataFine(_prenotazione.get(i).getDataFine());
				
			
			prenotazione.add(p);
		}

		return (List<PrenotazioneDto>)prenotazione;
	}
	

	
	public PrenotazioneDto convertEntityToDto(Prenotazione _prenotazione) {
		
		PrenotazioneDto prenotazione=new PrenotazioneDto();
		
			prenotazione.setCodiceFiscale(_prenotazione.getUtente().getCodiceFiscale());
			prenotazione.setDataFine(_prenotazione.getDataFine());
			prenotazione.setDataInizio(_prenotazione.getDataInizio());
			prenotazione.setSeriale(_prenotazione.getAuto().getSeriale());
		return prenotazione;
		
	}
	
	
	public Prenotazione convertDtoToEntity(PrenotazioneDto _prenotazione) {
		
		Prenotazione prenotazione= new Prenotazione();
		
		
		Optional<Auto>  auto = autoRepository.findBySeriale(_prenotazione.getSeriale());
		
		Optional<Utente>  utente = utenteRepository.findByCodiceFiscale(_prenotazione.getCodiceFiscale());
		
		//fai query id
//		int id= prenotazioneRepository.trovaMaxId();
//		id++;
		
		
	
		prenotazione.setUtente( utente.get() ); 
		
		prenotazione.setAuto(auto.get());
		
		prenotazione.setDataInizio(_prenotazione.getDataInizio());
		prenotazione.setDataFine(_prenotazione.getDataFine());
	
		
		return prenotazione;
		
	}
	
	
	
	
	

}
