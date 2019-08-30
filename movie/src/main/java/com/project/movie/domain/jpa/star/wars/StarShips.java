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
public class StarShips {
    private String name;
    private String model;
    private String manufacturer;
    private String crew;
    private String passengers;
    private String cargoCapacity;
    private String starshipClass;
    private String url;
    @Id
    @GeneratedValue
    private Long id;
}
