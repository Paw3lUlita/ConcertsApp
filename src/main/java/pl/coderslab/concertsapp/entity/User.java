package pl.coderslab.concertsapp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    @NotEmpty(message = "Nazwa użytkownika nie może być pusta!")
    @Size(min = 3, max = 60, message = "Nazwa użytkownika zawierać od 3 do 60 znaków!")
    private String username;

    @NotEmpty(message = "Pole \"hasło\" jest obowiązkowe!")

    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Size(min=1, message = "Wybierz przynajmniej jedną rolę")
    private Set<Role> roles;
}
