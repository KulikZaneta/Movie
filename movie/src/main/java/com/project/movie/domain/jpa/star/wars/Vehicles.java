package com.project.movie.domain.jpa.star.wars;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table
@Entity
public class Vehicles {
    private String name;
    private String model;
    private String length;
    private String crew;
    private String passengers;
    private String vehicleClass;
    private String url;
    @Id
    @GeneratedValue
    private Long id;
}
