package library.movies.domain.producers.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 150)
    @Column(length = 150, nullable = false)
    private String title;

    @Size(max = 150)
    @Column(length = 150, nullable = false)
    private String studio;

    @Size(max = 150)
    @Column(length = 150, nullable = false)
    private String producer;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private boolean winner;

}
