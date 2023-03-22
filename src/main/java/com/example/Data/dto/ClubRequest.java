package com.example.Data.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ClubRequest {
    private String FC;
    private String league;
    private String SPI;

}
