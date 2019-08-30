package com.project.movie.domain.rest.movie.lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DateUpcomingRest {
    private String maximum;
    private String minimum;
}
