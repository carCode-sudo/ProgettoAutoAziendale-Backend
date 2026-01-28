package com.progettoAuto.prenotazione.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.progettoAuto.prenotazione.model.Utente;


@Repository
public interface UtenteRepository extends CrudRepository<Utente,String>  {

	Optional<Utente> findById(Integer id);
	
	Optional<Utente> findByCodiceFiscale(String codiceFiscale);

}
