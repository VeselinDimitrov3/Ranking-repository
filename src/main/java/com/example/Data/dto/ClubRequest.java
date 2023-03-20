package com.example.Data.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClubRequest {
    private Long id;
    private String FC;
    private String league;
    private Integer SPI;

}
