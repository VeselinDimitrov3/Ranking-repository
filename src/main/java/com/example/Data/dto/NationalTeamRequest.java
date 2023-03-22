package com.example.Data.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Component
public class NationalTeamRequest {

    @NotNull
    @Size(min = 3, max = 20, message = "Team must contain 3 to 20 letters")
    private String team;

    @NotNull
    private String totalPoints;

    @NotNull
    private String previousPoints;

}
