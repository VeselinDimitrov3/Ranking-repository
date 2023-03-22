package com.example.Data.impl;

import com.example.Data.convertor.NationalTeamConvertor;
import com.example.Data.dto.NationalTeamRequest;
import com.example.Data.dto.NationalTeamResponse;
import com.example.Data.dto.NationalTeamUpdate;
import com.example.Data.entity.Clubs;
import com.example.Data.entity.NationalTeams;
import com.example.Data.exception.*;
import com.example.Data.repository.NationalTeamRepository;
import com.example.Data.service.NationalTeamService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.example.Data.util.VerUtil.isNationalTeamSaveOk;

@Service
public class NationalTeamServiceImpl implements NationalTeamService {
    private final NationalTeamRepository nationalTeamRepository;
    private final NationalTeamConvertor nationalTeamConvertor;

    @Autowired
    public NationalTeamServiceImpl(NationalTeamRepository nationalTeamRepository, NationalTeamConvertor nationalTeamConvertor) {
        this.nationalTeamRepository = nationalTeamRepository;
        this.nationalTeamConvertor = nationalTeamConvertor;
    }

    @Override
    @Transactional
    public NationalTeamResponse addNationalTeam(NationalTeamRequest nationalTeamRequest) throws NationalTeamDoublingException {
        NationalTeams newNationalTeam = null;
        if (isNationalTeamSaveOk(nationalTeamRepository.findAll(),
                nationalTeamRequest.getTeam())) {
            newNationalTeam = nationalTeamRepository.save(nationalTeamConvertor.toRequest(nationalTeamRequest));
        }
        return nationalTeamConvertor.toResponse(Objects.requireNonNull(newNationalTeam));
    }

    @Override
    public NationalTeams findByRankingPlace(Long id) {
        return nationalTeamRepository.findById(id).orElseThrow
        (() -> new RecordNotFoundException
                (String.format("National Team with id %d not found", id.intValue())));
    }

    @Override
    @Transactional
    public NationalTeamResponse updateNationalTeam(NationalTeamUpdate nationalTeamUpdate) {
        NationalTeams nationalTeams = nationalTeamRepository.findById(Long.parseUnsignedLong(nationalTeamUpdate.getId())).orElseThrow(() ->
                new NationalTeamNotFoundException(String.format("Team with id %s not found", nationalTeamUpdate.getId())));
        nationalTeams.setTotalPoints(nationalTeamUpdate.getNewTotalPoints());
        nationalTeams.setPreviousPoints(nationalTeamUpdate.getNewPreviousPoints());
        nationalTeamRepository.save(nationalTeams);
        return nationalTeamConvertor.toResponse(nationalTeams);
    }

    @Override
    public void deleteNationalTeam(Long id) {
        if (nationalTeamRepository.findById(id).isEmpty()) {
            throw new RecordNotFoundException(String.format("National Team with id %d not found", id.intValue()));
        } else {
            nationalTeamRepository.deleteById(id);
        }
    }
}
