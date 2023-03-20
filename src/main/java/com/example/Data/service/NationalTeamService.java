package com.example.Data.service;

import com.example.Data.dto.*;
import com.example.Data.entity.NationalTeams;

public interface NationalTeamService {

    NationalTeamResponse addNationalTeam(NationalTeamRequest nationalTeamRequest);

    NationalTeams findByRankingPlace(Long id);

    NationalTeamResponse updateNationalTeam(NationalTeamUpdate nationalTeamUpdate);

    void deleteNationalTeam(Long id);


}
