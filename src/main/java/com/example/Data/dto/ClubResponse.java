package com.example.Data.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClubResponse {
    private String FC;
    private String league;
    private String SPI;

}
