package pl.coderslab.concertsapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.concertsapp.entity.Club;
import pl.coderslab.concertsapp.entity.User;
import pl.coderslab.concertsapp.service.ClubService;
import pl.coderslab.concertsapp.service.UserService;

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


    @ModelAttribute("userClubs")
    public List<Club> getUserClubs(Principal principal){
        User user = userService.findByUserName(principal.getName());
        return clubService.findClubsForUser(user.getId());
    }
}
