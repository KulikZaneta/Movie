package com.project.movie.domain.jpa;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table
@Entity
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
