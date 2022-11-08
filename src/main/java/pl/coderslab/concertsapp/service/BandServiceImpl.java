package pl.coderslab.concertsapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.concertsapp.entity.Band;
import pl.coderslab.concertsapp.repository.BandRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class BandServiceImpl implements BandService {

    private final BandRepository bandRepository;

    @Override
    @Transactional
    public void saveBand(Band band) {
        bandRepository.save(band);
    }

    @Override
    @Transactional
    public void updateBand(Band band) {

        bandRepository.save(band);
    }

    @Override
    @Transactional
    public Band findBandByName(String bandName) {
        return bandRepository.findByName(bandName);
    }

    @Override
    @Transactional
    public Band findBandById(Long id) {
        return bandRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Band> findBandsForUser(Long userId) {
        return bandRepository.findBandsByUserId(userId);
    }

    @Override
    @Transactional
    public List<Band> findAllBands() {
        return bandRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteBandById(Long id) {
        bandRepository.deleteById(id);
    }
}
