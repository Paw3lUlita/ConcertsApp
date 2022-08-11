package pl.coderslab.concertsapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "event_band", joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "band_id"))
    private List<Band> bands;
}
