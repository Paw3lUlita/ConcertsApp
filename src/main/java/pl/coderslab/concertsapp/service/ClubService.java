package pl.coderslab.concertsapp.service;


import pl.coderslab.concertsapp.entity.Club;

import java.util.List;

public interface ClubService {

    void saveClub(Club club);

    void updateClub(Club club);

    Club findClubByName(String clubName);

    Club findClubById(Long id);

    List<Club> findClubsForUser(Long userId);

    List<Club> findAllClubs();

    void deleteClubById(Long id);

    List<String> getAllCities();

}
