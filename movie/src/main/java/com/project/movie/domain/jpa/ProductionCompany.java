package com.project.movie.domain.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class ProductionCompany {
    private String name;
    @Id
    @GeneratedValue
    private Long id;
    private String logo_path;
    private String origin_country;
}
