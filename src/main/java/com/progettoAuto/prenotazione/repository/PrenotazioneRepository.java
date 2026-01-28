package com.progettoAuto.prenotazione.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.progettoAuto.prenotazione.model.Prenotazione;




@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {
	

	List<Prenotazione> findByAuto_Seriale(String seriale);
	List<Prenotazione> findByUtente_CodiceFiscale(String codiceFiscale);
	
	
	
	@Query(value="  SELECT COUNT(id) FROM `prenotazione` WHERE ( (?1 BETWEEN data_inizio AND data_fine)"
			+ " OR (?2 BETWEEN data_inizio AND data_fine)  OR  "
			+ " (data_inizio BETWEEN ?1 AND ?2 )OR (data_fine BETWEEN ?1 AND ?2)   )  AND auto = ?3 " 
			,nativeQuery=true)
	int trovaData(LocalDate i, LocalDate f , String seriale);
	
//	@Query(value=" SELECT MAX(id) FROM prenotazione  " 
//			,nativeQuery=true)
//	int trovaMaxId();
	
	@Query(value=" INSERT INTO `prenotazione`(`auto`, `utente`, `data_fine`, `data_inizio`, `id`) VALUES "+
	"?1,?2,?3,?4,?5 " ,nativeQuery=true)
	Prenotazione savePrenotazione(String a,String b,LocalDate c, LocalDate d,int f );
	
	
	
	
	

}
