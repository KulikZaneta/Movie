package com.project.movie.domain.jpa;

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
public class Language {
    private String iso;
    private String name;
    @Id
    @GeneratedValue
    private Long id;
}
