package stud.kea.mfh.goatsite.model;

import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="goat1_id")
    private Goat goat1id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="goat2_id")
    private Goat goat2id;
}
