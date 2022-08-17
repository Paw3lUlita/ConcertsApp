package pl.coderslab.concertsapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.concertsapp.entity.Band;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.entity.Event;
import pl.coderslab.concertsapp.entity.User;
import pl.coderslab.concertsapp.service.BandService;
import pl.coderslab.concertsapp.service.ClubService;
import pl.coderslab.concertsapp.service.EventService;
import pl.coderslab.concertsapp.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/band")

    public class BandController {

    private final BandService bandService;
    private final UserService userService;
    private final EventService eventService;
    private final ClubService clubService;


    @GetMapping("")
    public String showUserBands(){
        return "band/bandList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        Band band = new Band();
        model.addAttribute(band);
        return "band/add";
    }

    @PostMapping("/add")
    public String addBand(Band band, Principal principal){
        User user = userService.findByUserName(principal.getName());
        band.setUser(user);
        bandService.saveBand(band);
        return "redirect:/band";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model){
        Band band = bandService.findBandById(id);
        model.addAttribute("band", band);
        return "band/edit";
    }

    @PostMapping("/edit/{id}")
    public String editBand(Band band){
        bandService.saveBand(band);
        return "redirect:/band";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteAlert(@PathVariable long id, Model model){
        Band band = bandService.findBandById(id);
        model.addAttribute("band", band);
        return "band/deleteAlert";
    }

    @GetMapping("/delete")
    public String deleteClub(@RequestParam long id, Model model){
        bandService.deleteBandByid(id);

        return "redirect:/band";
    }

    @GetMapping("/events/{bandId}")
    public String showBandDashboard(@PathVariable long bandId, Model model){

        List<Event> eventsForBand = eventService.findEventsForBand(bandId);
        model.addAttribute("bandId", bandId);
        model.addAttribute("eventsForBand", eventsForBand);
        return "band/eventList";

    }

    @GetMapping("/{bandId}/cancel/{eventId}")
    public String abortEvent(@PathVariable long bandId, @PathVariable long eventId){
        Event event = eventService.findEventById(eventId);
        Band band = bandService.findBandById(bandId);
        event.getBands().remove(band);
        eventService.saveEvent(event);
        return "redirect:/band/events/"+bandId;
    }


    @GetMapping("/allevents/cities")
    public String showAllCities(Model model){
        model.addAttribute("cities", clubService.getAllCities());
        return "band/citySearch";
    }

    @GetMapping("/cityevent/{city}")
    public String showAllEventsInCity(@PathVariable String city, Model model){
        model.addAttribute("city", city);
        model.addAttribute("cityEvents", eventService.findEventsByClubCity(city));
        return "band/cityEventsList";
    }

    @GetMapping("/allevents/clubs")
    public String showAllClubs(Model model){
        model.addAttribute("clubs", clubService.findAllClubs());
        return "band/clubSearch";
    }

    @GetMapping("/clubevent/{clubId}")
    public String showAlleventsInClub(@PathVariable long clubId, Model model){
        Club club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        model.addAttribute("clubEvents", eventService.findEventsForClub(club));
        return "band/clubEventsList";
    }


    @ModelAttribute("userBands")
    public List<Band> getUserBands(Principal principal){
        User user = userService.findByUserName(principal.getName());
        return bandService.findBandsForUser(user.getId());
    }


}
