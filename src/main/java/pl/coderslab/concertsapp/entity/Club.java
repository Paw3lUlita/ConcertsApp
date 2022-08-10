package pl.coderslab.concertsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "club")
@Data
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String city;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
