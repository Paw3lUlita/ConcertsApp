package pl.coderslab.concertsapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.repository.ClubRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Override
    @Transactional
    public void saveClub(Club club) {
        clubRepository.save(club);
    }

    @Override
    @Transactional
    public void updateClub(Club club) {

        clubRepository.save(club);

    }

    @Override
    @Transactional
    public Club findClubByName(String clubName) {

        return clubRepository.findByName(clubName);
    }

    @Override
    @Transactional
    public Club findClubById(Long id) {
        return clubRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Club> findClubsForUser(Long userId) {

        return clubRepository.findClubsByUserId(userId);
    }

    @Override
    @Transactional
    public List<Club> findAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteClubById(Long id) {
        clubRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<String> getAllCities() {
        return clubRepository.getAllCities();
    }
}
