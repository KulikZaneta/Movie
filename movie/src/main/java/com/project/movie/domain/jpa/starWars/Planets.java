package com.project.movie.domain.jpa.starWars;

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
public class Planets {
    private String name;
    private String climate;
    private String gravity;
    private String terrain;
    private String surfaceWater;
    private String population;
    private String url;
    @Id
    @GeneratedValue
    private Long id;
}
