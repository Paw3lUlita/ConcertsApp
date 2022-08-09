package pl.coderslab.concertsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "band")
@Data
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String bio;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
