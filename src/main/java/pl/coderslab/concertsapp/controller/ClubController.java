package pl.coderslab.concertsapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.entity.User;
import pl.coderslab.concertsapp.service.ClubService;
import pl.coderslab.concertsapp.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/club")
public class ClubController {

    private final ClubService clubService;
    private final UserService userService;


    @GetMapping("")
    public String showUserClubs(){
        return "club/clubList";
    }

    @GetMapping("/chooseclub/{clubId}")
    public String chooseClub(@PathVariable long clubId, HttpServletResponse response){
        Cookie cookie = new Cookie("clubId", String.valueOf(clubId));
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/event/"+clubId;
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        Club club = new Club();
        model.addAttribute(club);
        return "club/add";
    }

    @PostMapping("/add")
    public String addClub(Club club, Principal principal){
        User user = userService.findByUserName(principal.getName());
        club.setUser(user);
        clubService.saveClub(club);
        return "redirect:/club";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model){
        Club club = clubService.findClubById(id);
        model.addAttribute("club", club);
        return "club/edit";
    }

    @PostMapping("/edit/{id}")
    public String editClub(Club club){
        clubService.updateClub(club);
        return "redirect:/club";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteAlert(@PathVariable long id, Model model){
        Club club = clubService.findClubById(id);
        model.addAttribute("club", club);
        return "club/deleteAlert";
    }

    @GetMapping("/delete")
    public String deleteClub(@RequestParam long id, Model model){
        clubService.deleteClubById(id);

        return "redirect:/club";
    }

    @ModelAttribute("userClubs")
    public List<Club> getUserClubs(Principal principal){
        User user = userService.findByUserName(principal.getName());
        return clubService.findClubsForUser(user.getId());
    }
}
