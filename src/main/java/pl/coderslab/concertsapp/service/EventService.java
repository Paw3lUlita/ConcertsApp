package pl.coderslab.concertsapp.service;

import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.entity.Event;

import java.util.List;

public interface EventService {

    List<Event> findEventsForBand(Long bandId);

    List<Event> findEventsForClub(Club club);

    List<Event> findAll();

    void saveEvent(Event event);

    void updateEvent(Event event);

    Event findEventById(Long id);

    Event findEventByName(String name);

    void deleteEventById(Long id);

    List<Event> findEventsByClubCity(String city);

}
