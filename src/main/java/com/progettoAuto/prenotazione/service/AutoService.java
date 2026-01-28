package com.progettoAuto.prenotazione.service;


import java.util.List;
import java.util.Optional;

import com.progettoAuto.prenotazione.Dto.AutoDto;
import com.progettoAuto.prenotazione.model.Auto;

public interface AutoService{
	
	public Auto saveAuto(Auto auto);

	public List<Auto> getAllAuto();
	
	public Optional<Auto> getSingleAuto(Integer id);
	
	public AutoDto convertEntityToDto(Auto p);
	
}
