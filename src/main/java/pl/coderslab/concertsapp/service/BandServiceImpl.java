package pl.coderslab.concertsapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.concertsapp.entity.Band;
import pl.coderslab.concertsapp.repository.BandRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BandServiceImpl implements BandService {

    private final BandRepository bandRepository;

    @Override
    public void saveBand(Band band) {
        bandRepository.save(band);
    }

    @Override
    public void updateBand(Band band) {

        bandRepository.save(band);
    }

    @Override
    public Band findBandByName(String bandName) {
        return bandRepository.findByName(bandName);
    }

    @Override
    public Band findBandById(Long id) {
        return bandRepository.findById(id).get();
    }

    @Override
    public List<Band> findBandsForUser(Long userId) {
        return bandRepository.findBandsByUserId(userId);
    }

    @Override
    public List<Band> findAllBands() {
        return bandRepository.findAll();
    }

    @Override
    public void deleteBandByid(Long id) {
        bandRepository.deleteById(id);
    }
}
