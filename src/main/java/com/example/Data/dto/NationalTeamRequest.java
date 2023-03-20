package com.example.Data.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class NationalTeamRequest {
    private Long id;
    private String team;
    private Integer totalPoints;
    private Integer previousPoints;

}
