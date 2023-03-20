package com.example.Data.dto;

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
    private String newId;
    private String newTotalPoints;
    private Integer newPreviousPoints;

}
