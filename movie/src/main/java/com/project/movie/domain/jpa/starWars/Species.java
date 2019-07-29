package com.project.movie.domain.jpa.starWars;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table
@Entity
public class Species {
    private String name;
    private String averageHeight;
    private String skinColors;
    private String hairColors;
    private String eyeColors;
    private String homeworld;
    private String language;
    private String url;
    @Id
    @GeneratedValue
    private Long id;
}
