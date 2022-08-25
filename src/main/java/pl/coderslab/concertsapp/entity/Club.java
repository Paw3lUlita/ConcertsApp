package pl.coderslab.concertsapp.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "club")
@Data
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Nazwa klubu nie może być pusta!")
    @Size(min=2, message = "Nazwa klubu musi mieć co najmniej dwa znaki!")
    private String name;

    @NotEmpty(message = "Nazwa miasta nie może być pusta!")
    @Size(min=3, message = "Nazwa miasta musi mieć co najmniej trzy znaki!")
    private String city;

    @NotEmpty(message = "Musisz podac adres!")
    private String address;

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
