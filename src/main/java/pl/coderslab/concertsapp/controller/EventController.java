package pl.coderslab.concertsapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.concertsapp.entity.Band;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.entity.Event;
import pl.coderslab.concertsapp.entity.User;
import pl.coderslab.concertsapp.service.ClubService;
import pl.coderslab.concertsapp.service.EventService;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;
    private final ClubService clubService;

    @GetMapping("/{clubId}")
    public String showEventList(@PathVariable long clubId, Model model){
        Club club = clubService.findClubById(clubId);
        List<Event> clubEvents = eventService.findEventsForClub(club);
        model.addAttribute("clubId", clubId);
        model.addAttribute("clubEvents", clubEvents);
        return "eventForClub/eventList";
    }

    @GetMapping("/{clubId}/add")
    public String showAddForm(@PathVariable long clubId, Model model){
        Event event = new Event();
        Club club = clubService.findClubById(clubId);
        event.setClub(club);
        model.addAttribute("event", event);
        return "eventForClub/add";
    }

    @PostMapping("/{clubId}/add")
    public String addEvent(@PathVariable long clubId, @RequestParam(name = "date") String date, Event event){
        event.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        eventService.saveEvent(event);
        return "redirect:/event/"+clubId;
    }

}
