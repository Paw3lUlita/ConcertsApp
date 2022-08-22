package pl.coderslab.concertsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.concertsapp.entity.Ask;

import pl.coderslab.concertsapp.entity.Club;

import java.util.List;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {

    @Query(value = "SELECT a.id, a.message, a.band_id, a.event_id from ask a " +
            "JOIN event e on e.id = a.event_id " +
            "WHERE club_id=:clubId", nativeQuery = true)
    List<Ask> findAllByClub(Long clubId);

}
