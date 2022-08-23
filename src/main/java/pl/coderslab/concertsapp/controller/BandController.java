package pl.coderslab.concertsapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.concertsapp.entity.*;
import pl.coderslab.concertsapp.service.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/band")

    public class BandController {

    private final BandService bandService;
    private final UserService userService;
    private final EventService eventService;
    private final ClubService clubService;
    private final AskService askService;


    @GetMapping("")
    public String showUserBands(){
        return "band/bandList";
    }

    @GetMapping("/chooseband/{bandId}")

    public String chooseBand(@PathVariable long bandId, HttpServletResponse response){

        Cookie cookie = new Cookie("bandId", String.valueOf(bandId));
        cookie.setPath("/");
        response.addCookie(cookie);

        /*Band band = bandService.findBandById(bandId);
        Cookie cookie2 = new Cookie("bandName", band.getName());
        cookie2.setPath("/");
        response.addCookie(cookie2);*/

        return "redirect:/band/events/"+bandId;
    }


    @GetMapping("/add")
    public String showAddForm(Model model){
        Band band = new Band();
        model.addAttribute(band);
        return "band/add";
    }

    @PostMapping("/add")
    public String addBand(@Valid Band band, BindingResult result, Principal principal){

        if(result.hasErrors()){
            return "band/add";
        }

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
    public String editBand(@Valid Band band, BindingResult result){
        if(result.hasErrors()){
            return "band/edit";
        }
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

    @GetMapping("/search")
    public String getSearchPage(HttpServletRequest request){

        boolean cookiePresent = Arrays.asList( request.getCookies() ).stream().anyMatch(cookie -> cookie.getName().equals("bandId"));

        if(cookiePresent == false){
            return "band/chooseBandAlert";
        }
        return "band/search";
    }

    @GetMapping("/events/{bandId}")
    public String showBandDashboard(@PathVariable long bandId, Model model){



        List<Event> eventsForBand = eventService.findEventsForBand(bandId);
        model.addAttribute("bandId", bandId);
        model.addAttribute("eventsForBand", eventsForBand);
        return "band/eventList";

    }

    @GetMapping("/events/err")
    public String getChooseAlert(){
        return "band/chooseBandAlert";
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
    public String showAllEventsInCity(@PathVariable String city, @CookieValue long bandId, Model model){
        model.addAttribute("city", city);
        List<Event> eventsToJoin = eventService.findEventsByClubCity(city);
        Band band = bandService.findBandById(bandId);

        for (Event event : eventsToJoin){
            for (Band b : event.getBands()){
                if (b.equals(band)){
                    eventsToJoin.remove(event);
                }
            }
        }
        model.addAttribute("cityEvents", eventsToJoin);
        return "band/cityEventsList";
    }

    @GetMapping("/allevents/clubs")
    public String showAllClubs(Model model){
        model.addAttribute("clubs", clubService.findAllClubs());
        return "band/clubSearch";
    }

    @GetMapping("/clubevent/{clubId}")
    public String showAlleventsInClub(@PathVariable long clubId, @CookieValue long bandId, Model model){
        Club club = clubService.findClubById(clubId);
        model.addAttribute("club", club);

        List<Event> eventsToJoin = eventService.findEventsForClub(club);
        Band band = bandService.findBandById(bandId);

        for (Event event : eventsToJoin){
            for (Band b : event.getBands()){
                if (b.equals(band)){
                    eventsToJoin.remove(event);
                }
            }
        }

        model.addAttribute("clubEvents", eventsToJoin);
        return "band/clubEventsList";
    }

    @GetMapping("/bandjoin/{eventId}")
    public String showAskForm(@CookieValue String bandId,
                              @PathVariable long eventId, Model model){
        Ask ask = new Ask();
        Band band = bandService.findBandById(Long.parseLong(bandId));
        Event event = eventService.findEventById(eventId);

         if(event.getBands().size()==5){
             String warningMessage = "W evencie uczestniczy już maksymalna liczba zespołów. \n" +
                     "Wciąż możesz wysłać wiadomość, zeby organizator wziął cię pod uwagę podczas kolejnych eventów";
             model.addAttribute("warningMessage", warningMessage);
         }
        ask.setBand(band);
        ask.setEvent(event);
        model.addAttribute("ask", ask);
        return "band/askAdd";
    }

    @PostMapping("/bandjoin/{eventId}")
    public String sendAsk(@PathVariable long eventId, @Valid Ask ask, BindingResult result){

        if(result.hasErrors()){
            return "band/askAdd";
        }

        askService.saveAsk(ask);
        return "redirect:/band/events/"+ask.getBand().getId();
    }

    @ModelAttribute("userBands")
    public List<Band> getUserBands(Principal principal){
        User user = userService.findByUserName(principal.getName());
        return bandService.findBandsForUser(user.getId());
    }


}
