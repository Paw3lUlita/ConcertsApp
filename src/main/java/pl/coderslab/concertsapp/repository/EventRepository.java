package pl.coderslab.concertsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.concertsapp.entity.Band;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.entity.Event;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e JOIN e.bands b WHERE b.id = :bandId")
    List<Event> findEventsByBand(Long bandId);

    List<Event> findEventsByClub(Club club);

    Event findEventByName(String name);

    List<Event> findEventsByClubCity(String city);


}
