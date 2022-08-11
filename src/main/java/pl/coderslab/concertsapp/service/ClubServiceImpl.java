package pl.coderslab.concertsapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.repository.ClubRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Override
    public void saveClub(Club club) {
        clubRepository.save(club);
    }

    @Override
    public void updateClub(Long id) {
        Club club = findClubById(id);
        clubRepository.save(club);

    }

    @Override
    public Club findClubByName(String clubName) {

        return clubRepository.findByName(clubName);
    }

    @Override
    public Club findClubById(Long id) {
        return clubRepository.findById(id).get();
    }

    @Override
    public List<Club> findClubsForUser(Long userId) {

        return clubRepository.findClubsByUserId(userId);
    }

    @Override
    public List<Club> findAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public void deleteClubById(Long id) {
        clubRepository.deleteById(id);
    }
}
