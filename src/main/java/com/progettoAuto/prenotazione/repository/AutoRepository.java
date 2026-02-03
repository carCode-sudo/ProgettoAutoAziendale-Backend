package com.progettoAuto.prenotazione.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progettoAuto.prenotazione.model.Auto;


@Repository
public interface AutoRepository extends JpaRepository<Auto,Integer>  {
	
	Optional<Auto> findAutoBySeriale(String seriale);
	Optional<Auto> findById_(int id);

}
