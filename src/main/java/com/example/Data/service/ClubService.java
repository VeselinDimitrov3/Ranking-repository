package com.example.Data.service;

import com.example.Data.dto.ClubRequest;
import com.example.Data.dto.ClubResponse;
import com.example.Data.dto.ClubUpdate;
import com.example.Data.entity.Clubs;
import com.example.Data.exception.ClubDoublingException;
import com.example.Data.exception.RecordNotFoundException;

public interface ClubService {

    ClubResponse addClub (ClubRequest clubRequest) throws ClubDoublingException, RecordNotFoundException;

    Clubs findByRankingPlace(Long id);

    ClubResponse updateClub(ClubUpdate clubUpdate);

    void deleteClub(Long id);


}
