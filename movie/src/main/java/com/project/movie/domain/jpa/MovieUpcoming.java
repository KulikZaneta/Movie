package com.project.movie.domain.jpa;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table
@Entity
public class MovieUpcoming {
    @Id
    @GeneratedValue
    private Long page;
    private LocalDate maximum;
    private LocalDate minimum;

}
