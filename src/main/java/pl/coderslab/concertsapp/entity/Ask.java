package pl.coderslab.concertsapp.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ask")
@Data
public class Ask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @OneToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToOne
    @JoinColumn(name = "band_id")
    private Band band;
}
