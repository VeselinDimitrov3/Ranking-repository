package com.example.Data.convertor;

import com.example.Data.dto.NationalTeamRequest;
import com.example.Data.dto.NationalTeamResponse;
import com.example.Data.entity.NationalTeams;

public class NationalTeamConvertor {

    public NationalTeams toRequest(NationalTeamRequest nationalTeamRequest) {
        return NationalTeams.builder()
                .id(nationalTeamRequest.getId())
                .team(nationalTeamRequest.getTeam())
                .totalPoints(nationalTeamRequest.getTotalPoints())
                .previousPoints(nationalTeamRequest.getPreviousPoints())
                .build();
    }

    public NationalTeamResponse toResponse(NationalTeams nationalTeams) {
        return NationalTeamResponse.builder()
                .id(nationalTeams.getId())
                .team(nationalTeams.getTeam())
                .totalPoints(nationalTeams.getTotalPoints())
                .previousPoints(nationalTeams.getPreviousPoints())
                .build();

    }
}
