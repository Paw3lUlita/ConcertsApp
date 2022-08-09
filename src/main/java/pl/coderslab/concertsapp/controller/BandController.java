package pl.coderslab.concertsapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.concertsapp.entity.Band;
import pl.coderslab.concertsapp.entity.User;
import pl.coderslab.concertsapp.repository.BandRepository;
import pl.coderslab.concertsapp.repository.UserRepository;
import pl.coderslab.concertsapp.service.BandService;
import pl.coderslab.concertsapp.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/band")

    public class BandController {

    private final BandService bandService;
    private final UserService userService;


    @GetMapping("")
    public String showUserBands(){
        return "band/bandList";
    }


    @ModelAttribute("userBands")
    public List<Band> getUserBands(Principal principal){
        User user = userService.findByUserName(principal.getName());
        return bandService.findBandsForUser(user.getId());
    }
}
