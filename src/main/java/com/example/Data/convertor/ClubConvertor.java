package com.example.Data.convertor;

import com.example.Data.dto.ClubRequest;
import com.example.Data.dto.ClubResponse;
import com.example.Data.entity.Clubs;
import org.springframework.stereotype.Component;
@Component
public class ClubConvertor {
    public Clubs toRequest(ClubRequest clubRequest) {
        return Clubs.builder()
                .id(clubRequest.getId())
                .FC(clubRequest.getFC())
                .league(clubRequest.getLeague())
                .SPI(clubRequest.getSPI())
                .build();
    }
    public ClubResponse toResponse (Clubs clubs) {
        return ClubResponse.builder()
                .id(clubs.getId())
                .FC(clubs.getFC())
                .league(clubs.getLeague())
                .SPI(clubs.getSPI())
                .build();
    }

}
