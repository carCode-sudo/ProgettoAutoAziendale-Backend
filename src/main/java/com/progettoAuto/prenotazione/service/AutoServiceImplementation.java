package com.progettoAuto.prenotazione.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progettoAuto.prenotazione.Dto.AutoDto;
import com.progettoAuto.prenotazione.Mapper.Mapper;
import com.progettoAuto.prenotazione.model.Auto;
import com.progettoAuto.prenotazione.repository.AutoRepository;


@Service
public class AutoServiceImplementation implements AutoService {


	@Autowired
	private AutoRepository  autoRepository;
	@Autowired
	private Mapper  mapper;

	@Override
	public Auto saveAuto(Auto auto) {			
		return autoRepository.save(auto);
		
	}
	@Override
	public List<Auto> getAllAuto(){

		List<Auto> auto= autoRepository.findAll();

	return auto;
			
	}

	public Optional<Auto> getSingleAuto(Integer id) {
		
		return autoRepository.findById_(id);
		
	}

	@Override
	public AutoDto convertEntityToDto(Auto p) {
		// TODO Auto-generated method stub
		return null;
	}



	
	
	
	
	
}
