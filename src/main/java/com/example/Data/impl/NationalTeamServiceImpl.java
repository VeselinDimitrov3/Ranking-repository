package com.example.Data.impl;

import com.example.Data.convertor.NationalTeamConvertor;
import com.example.Data.dto.NationalTeamRequest;
import com.example.Data.dto.NationalTeamResponse;
import com.example.Data.dto.NationalTeamUpdate;
import com.example.Data.entity.Clubs;
import com.example.Data.entity.NationalTeams;
import com.example.Data.exception.ClubNotFoundException;
import com.example.Data.exception.NationalTeamNotFoundException;
import com.example.Data.repository.NationalTeamRepository;
import com.example.Data.service.NationalTeamService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class NationalTeamServiceImpl implements NationalTeamService {
    private final NationalTeamRepository nationalTeamRepository;
    private final NationalTeamConvertor convertor;

    public NationalTeamServiceImpl(NationalTeamRepository nationalTeamRepository, NationalTeamConvertor convertor) {
        this.nationalTeamRepository = nationalTeamRepository;
        this.convertor = convertor;
    }

    @Override
    @Transactional
    public NationalTeamResponse addNationalTeam(NationalTeamRequest nationalTeamRequest) {
        NationalTeams nationalTeams = nationalTeamRepository.save(convertor.toRequest(nationalTeamRequest));
        return convertor.toResponse(nationalTeams);
    }

    @Override
    public NationalTeams findByRankingPlace(Long id) {
        return nationalTeamRepository.findById(id).orElseThrow
        (() -> new NationalTeamNotFoundException
                (String.format("National Team with id %d not found", id.intValue())));
    }

    @Override
    @Transactional
    public NationalTeamResponse updateNationalTeam(NationalTeamUpdate nationalTeamUpdate) {
        NationalTeams nationalTeam = nationalTeamRepository.findById(Long.parseUnsignedLong(nationalTeamUpdate.getNewId())).orElseThrow(() ->
                new NationalTeamNotFoundException(String.format("National Team with id %s not found", nationalTeamUpdate.getNewId())));
        nationalTeam.setTotalPoints(Integer.valueOf(String.valueOf(nationalTeamUpdate.getNewTotalPoints())));
        nationalTeam.setPreviousPoints(Integer.valueOf(String.valueOf(nationalTeamUpdate.getNewPreviousPoints())));
        nationalTeamRepository.save(nationalTeam);
        return convertor.toResponse(nationalTeam);
    }

    @Override
    public void deleteNationalTeam(Long id) {
        if (nationalTeamRepository.findById(id).isEmpty()) {
            throw new NationalTeamNotFoundException(String.format("National Team with id %d not found", id.intValue()));
        } else {
            nationalTeamRepository.deleteById(id);
        }
    }
}
