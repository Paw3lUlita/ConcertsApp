package pl.coderslab.concertsapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.concertsapp.entity.Band;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.entity.Event;
import pl.coderslab.concertsapp.entity.User;
import pl.coderslab.concertsapp.service.AskService;
import pl.coderslab.concertsapp.service.BandService;
import pl.coderslab.concertsapp.service.ClubService;
import pl.coderslab.concertsapp.service.EventService;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;
    private final ClubService clubService;
    private final BandService bandService;
    private final AskService askService;

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
    public String addEvent(@PathVariable long clubId, @RequestParam(name = "date") String date, @Valid Event event, BindingResult result){

        if(result.hasErrors()){
            return "eventForClub/add";
        }

        event.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        eventService.saveEvent(event);
        return "redirect:/event/"+clubId;
    }

    @GetMapping("/edit/{id}")

    public String showEditForm(@PathVariable long id, Model model){
        Event event = eventService.findEventById(id);
        /*Set<Band> bandsToAdd = new HashSet<>();
        for (Band b : bandService.findAllBands()){
            for(Band eventBand: event.getBands()){
                if(!b.equals(eventBand)){
                    bandsToAdd.add(b);
                }
            }
        }*/

        model.addAttribute("event", event);
        return "eventForClub/edit";

    }

    @PostMapping("/edit/{id}")
    public String editEvent(@Valid Event event, BindingResult result){
        if(result.hasErrors()){
            return "eventForClub/edit";
        }

        eventService.saveEvent(event);
        return "redirect:/event/"+event.getClub().getId();
    }

    @GetMapping("/delete/{id}")
    public String showDeleteAlert(@PathVariable long id, Model model){
        Event event = eventService.findEventById(id);
        model.addAttribute("event", event);
        model.addAttribute("clubId", event.getClub().getId());
        return "eventForClub/deleteAlert";
    }

    @GetMapping("/delete")
    public String deleteEvent(@RequestParam long id){

        long clubId = eventService.findEventById(id).getClub().getId();
        eventService.deleteEventById(id);

        return "redirect:/event/"+clubId;
    }

    @GetMapping("/{eventId}/bandremove/{bandId}")
    public String removeBandFromEvent(@PathVariable long eventId, @PathVariable long bandId){
        Event event = eventService.findEventById(eventId);
        Band band = bandService.findBandById(bandId);
        event.getBands().remove(band);
        eventService.saveEvent(event);
        return "redirect:/event/"+event.getClub().getId();
    }


    @GetMapping("/{eventId}/{bandId}/{askId}")
    public String addBandToEvent(@PathVariable long eventId,
                                 @PathVariable long bandId,
                                 @PathVariable long askId){
        Event event = eventService.findEventById(eventId);

        if(event.getBands().size() == 5){
            return "eventForClub/addAlert";
        }

        Band band = bandService.findBandById(bandId);
        event.getBands().add(band);
        eventService.saveEvent(event);
        askService.deleteAskById(askId);
        return "redirect:/club/messages/"+event.getClub().getId();
    }

    @GetMapping("/rejectband/{askId}")
    public String rejectAsk(@PathVariable long askId){

        long clubId = askService.findAskbyId(askId).getEvent().getClub().getId();

        askService.deleteAskById(askId);


        return "redirect:/club/messages/"+clubId;
    }



    @ModelAttribute("allBands")
    public List<Band> getAllBands(){
        return bandService.findAllBands();

    }

}
