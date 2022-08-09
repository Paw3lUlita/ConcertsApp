package pl.coderslab.concertsapp.service;

import pl.coderslab.concertsapp.entity.Role;
import pl.coderslab.concertsapp.entity.User;

import java.util.Set;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}
