package com.example.Data.service;

import com.example.Data.dto.*;
import com.example.Data.entity.NationalTeams;
import com.example.Data.exception.NationalTeamDoublingException;
import com.example.Data.exception.RecordNotFoundException;

public interface NationalTeamService {

    NationalTeamResponse addNationalTeam(NationalTeamRequest nationalTeamRequest) throws NationalTeamDoublingException , RecordNotFoundException;

    NationalTeams findByRankingPlace(Long id);

    NationalTeamResponse updateNationalTeam(NationalTeamUpdate nationalTeamUpdate);

    void deleteNationalTeam(Long id);


}
