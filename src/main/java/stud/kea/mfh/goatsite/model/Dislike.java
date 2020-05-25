package stud.kea.mfh.goatsite.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dislikes")
public class Dislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="goat_disliker_id")
    private Goat goatDisliker;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="goat_disliked_id")
    private Goat goatDisliked;

}
