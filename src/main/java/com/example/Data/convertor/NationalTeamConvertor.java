package com.example.Data.convertor;

import com.example.Data.dto.NationalTeamRequest;
import com.example.Data.dto.NationalTeamResponse;
import com.example.Data.entity.NationalTeams;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class NationalTeamConvertor {

    public NationalTeams toRequest(NationalTeamRequest nationalTeamRequest) {
        return NationalTeams.builder()
                .team(nationalTeamRequest.getTeam())
                .totalPoints(nationalTeamRequest.getTotalPoints())
                .previousPoints(nationalTeamRequest.getPreviousPoints())
                .build();
    }

    public NationalTeamResponse toResponse(NationalTeams nationalTeams) {
        return NationalTeamResponse.builder()
                .team(nationalTeams.getTeam())
                .totalPoints(nationalTeams.getTotalPoints())
                .previousPoints(nationalTeams.getPreviousPoints())
                .build();

    }
}
