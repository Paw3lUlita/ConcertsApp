package pl.coderslab.concertsapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.concertsapp.entity.Ask;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.repository.AskRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class AskServiceImpl implements AskService {

    private final AskRepository askRepository;

    @Override
    @Transactional
    public List<Ask> findAsksByClub(Long clubId) {
        return askRepository.findAllByClub(clubId);
    }


    @Override
    @Transactional
    public void saveAsk(Ask ask) {
        askRepository.save(ask);
    }

    @Override
    @Transactional
    public void deleteAskById(long askId) {
        askRepository.deleteById(askId);
    }

    @Override
    @Transactional
    public Ask findAskbyId(long askId) {
        return askRepository.findById(askId).get();
    }
}
