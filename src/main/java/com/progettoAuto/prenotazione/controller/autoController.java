package com.progettoAuto.prenotazione.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progettoAuto.prenotazione.Dto.AutoDto;
import com.progettoAuto.prenotazione.model.Auto;
import com.progettoAuto.prenotazione.service.AutoService;

@RestController
@RequestMapping("/auto")
public class autoController {

	
	@Autowired
	private AutoService autoService;
	
		@PostMapping("/add")
		public String add(@RequestBody Auto auto) {
			
				autoService.saveAuto(auto);
			return "new auto inserita";
		}
		
		@GetMapping("/getAll")
		public ResponseEntity<List<Auto>> getAllAuto(){
			
			return ResponseEntity.ok(autoService.getAllAuto());
		}
		
		
		@GetMapping("/get/{id}")
		public Optional<Auto> getSingleAuto(@PathVariable Integer id) {
			
			return autoService.getSingleAuto(id);
			
		}


	
		
		
		
		
		
}
