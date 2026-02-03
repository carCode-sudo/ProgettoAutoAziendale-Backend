package com.progettoAuto.prenotazione.service;

import com.progettoAuto.prenotazione.Dto.PrenotazioneDto;
import com.progettoAuto.prenotazione.model.Prenotazione;
import com.progettoAuto.prenotazione.model.Utente;

import java.util.List;

public interface PrenotazioneService {

    public boolean effettuaPrenotazione(Prenotazione prenotazione, Utente utente);
    public List<Prenotazione> getAllPrenotazioni(String codiceFiscale);
    public boolean insertPrenotazione( PrenotazioneDto _prenotazione);


}
