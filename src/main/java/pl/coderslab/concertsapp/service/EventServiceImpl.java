package pl.coderslab.concertsapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.entity.Event;
import pl.coderslab.concertsapp.repository.BandRepository;
import pl.coderslab.concertsapp.repository.EventRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;


    @Override
    public List<Event> findEventsForBand(Long bandId) {
        return eventRepository.findEventsByBand(bandId);
    }

    @Override
    public List<Event> findEventsForClub(Club club) {

        return eventRepository.findEventsByClub(club);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Event findEventById(Long id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public Event findEventByName(String name) {
        return eventRepository.findEventByName(name);
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
}
