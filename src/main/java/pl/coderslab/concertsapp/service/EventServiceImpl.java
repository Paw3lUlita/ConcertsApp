package pl.coderslab.concertsapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.entity.Event;
import pl.coderslab.concertsapp.repository.BandRepository;
import pl.coderslab.concertsapp.repository.EventRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;


    @Override
    @Transactional
    public List<Event> findEventsForBand(Long bandId) {
        return eventRepository.findEventsByBand(bandId);
    }

    @Override
    @Transactional
    public List<Event> findEventsForClub(Club club) {

        return eventRepository.findEventsByClub(club);
    }

    @Override
    @Transactional
    public List<Event> findAll() {
        return eventRepository.findAll();
    }


    @Override
    @Transactional
    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    @Transactional
    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    @Transactional
    public Event findEventById(Long id) {
        return eventRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Event findEventByName(String name) {
        return eventRepository.findEventByName(name);
    }

    @Override
    @Transactional
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Event> findEventsByClubCity(String city) {
        return eventRepository.findEventsByClubCity(city);
    }
}
