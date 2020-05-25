package stud.kea.mfh.goatsite.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data // Generates getters and setters for all fields on compiletime
@Entity
@Table(name = "goats")
public class Goat {

    @Transient
    private long userID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;

    @Length(max=120)
    private String shortDescription;


    @Length(max = 10000)
    private String longDescription;


    private String address;

    @Max(value = 10000)
    private long postnumber;

    private String city;

    @Email(message = "Email should be valid")
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    // Constraints
    // Like
    @OneToMany(mappedBy = "goatLiker")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Like> goatLikers;

    @OneToMany(mappedBy = "goatLiked")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Like> goatLikeds;

    // Dislike
    @OneToMany(mappedBy = "goatDisliker")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Dislike> goatDislikers;

    @OneToMany(mappedBy = "goatDisliked")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Dislike> goatDislikeds;

    // Match
    @OneToMany(mappedBy = "goat1id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Match> goat1Matches;

    @OneToMany(mappedBy = "goat2id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Match> goat2Matches;
}
