package pl.coderslab.concertsapp.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Nazwa wydarzenia nie może być pusta!")
    private String name;

    @NotEmpty(message = "Opis nie może być pusty!")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Data musi być datą z przyszłości!")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "event_band", joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "band_id"))
    @Size(max=5, message = "W wydarzeniu nie może uczestniczyć więcej niż 5 zespołów!")
    private List<Band> bands;
}
