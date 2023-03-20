package com.example.Data.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NationalTeamResponse {
    private Long id;
    private String team;
    private Integer totalPoints;
    private Integer previousPoints;

}
