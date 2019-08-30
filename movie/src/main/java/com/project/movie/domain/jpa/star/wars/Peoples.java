package com.project.movie.domain.jpa.star.wars;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table
@Entity
public class Peoples {
    private String name;
    private String height;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String url;
    @Id
    @GeneratedValue
    private Long id;
}
