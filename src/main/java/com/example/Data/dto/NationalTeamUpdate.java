package com.example.Data.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NationalTeamUpdate {
    @NotNull
    @Size(min = 1, max = 3)
    private String id;

    @NotNull
    private String newTotalPoints;

    @NotNull
    private String newPreviousPoints;

}
