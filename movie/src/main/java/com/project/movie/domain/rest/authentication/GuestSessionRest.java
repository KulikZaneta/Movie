package com.project.movie.domain.rest.authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class GuestSessionRest {
    private Boolean success;
    private String guest_session_id;
    private String expires_at;
}
