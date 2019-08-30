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
public class Films {
    private String title;
    private Long episodeId;
    private String director;
    private String producer;
    private String releaseDate;
    private String url;
    @Id
    @GeneratedValue
    private Long id;
}
