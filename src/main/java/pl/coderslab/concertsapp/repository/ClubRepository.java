package pl.coderslab.concertsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.concertsapp.entity.Club;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    Club findByName(String clubName);

    List<Club> findClubsByUserId(Long userId);

    @Query("SELECT DISTINCT c.city FROM Club c ")
    List<String> getAllCities();



}
