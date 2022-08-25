package pl.coderslab.concertsapp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "band")
@Data
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Nazwa zespołu nie może być pusta!")
    @Size(min = 2, message = "Nazwa zespółu musi zawierać conajmniej dwa znaki!")
    private String name;

    @NotEmpty(message = "Bio nie może być puste!")
    private String bio;

    @NotEmpty(message = "Musisz podać numer telefonu!")
    private int phoneNumber;

    @Email(message = "Niepoprawny adres email!")
    @NotEmpty(message = "Musisz podać adres email!")
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
