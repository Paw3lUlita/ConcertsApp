package pl.coderslab.concertsapp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

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

    @NotEmpty(message = "Musisz podać miasto!")
    @Size(min=3, message = "Nazwa miasta musi mieć co najmniej trzy znaki!")
    private String city;

    @NotEmpty(message = "Bio nie może być puste!")
    private String bio;

    @NotEmpty(message = "Musisz podać numer telefonu!")
    @Pattern(regexp = "[0-9]{9}", message = "Nieprawidłowy numer telefonu!")
    private String phoneNumber;

    @Email(message = "Niepoprawny adres email!")
    @NotEmpty(message = "Musisz podać adres email!")
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
