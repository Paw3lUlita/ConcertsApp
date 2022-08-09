package pl.coderslab.concertsapp.service;

import pl.coderslab.concertsapp.entity.Band;

import java.util.List;

public interface BandService {

    void saveBand(Band band);

    void updateBand(Long id);

    Band findBandByName(String bandName);

    Band findBandById(Long id);

    List<Band> findBandsForUser(Long userId);

    List<Band> findAllBands();

}
