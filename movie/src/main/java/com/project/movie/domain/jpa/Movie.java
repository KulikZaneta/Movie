package com.project.movie.domain.jpa;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String originalLanguage;
    private LocalDate releaseDate;
    private Double popularity;
    @Column(unique = true)
    private Long restId;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "movie_details_id")
    private MovieDetails movieDetails;
}
