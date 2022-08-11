package pl.coderslab.concertsapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.concertsapp.entity.Band;
import pl.coderslab.concertsapp.entity.Event;
import pl.coderslab.concertsapp.entity.Role;
import pl.coderslab.concertsapp.entity.User;
import pl.coderslab.concertsapp.repository.EventRepository;
import pl.coderslab.concertsapp.service.RoleService;
import pl.coderslab.concertsapp.service.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomePageController {


    private final RoleService roleService;
    private final UserService userService;
    private final EventRepository eventRepository;





    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        User user = new User();
        model.addAttribute(user);

        return "homepage/register";
    }





    @PostMapping("/register")
    public String saveUser(User user){
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String showDashboard(){
        return "homepage/dashboard";
    }

    @ModelAttribute("roles")
    public List<Role> getAllRoles(){
        return roleService.findAllRoles();
    }

}
