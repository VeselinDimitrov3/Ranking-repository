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
    private String team;
    private String totalPoints;
    private String previousPoints;

}
