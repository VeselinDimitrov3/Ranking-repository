package com.example.Data.impl;

import com.example.Data.convertor.ClubConvertor;
import com.example.Data.dto.ClubRequest;
import com.example.Data.dto.ClubResponse;
import com.example.Data.dto.ClubUpdate;
import com.example.Data.entity.Clubs;
import com.example.Data.exception.ClubDoublingException;
import com.example.Data.exception.ClubNotFoundException;
import com.example.Data.repository.ClubRepository;
import com.example.Data.service.ClubService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.example.Data.util.VerUtil.isClubSaveOk;

@Service
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;
    private final ClubConvertor clubConvertor;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository, ClubConvertor clubConvertor) {
        this.clubRepository = clubRepository;
        this.clubConvertor = clubConvertor;
    }

    @Override
    @Transactional
    public ClubResponse addClub (ClubRequest clubRequest) throws ClubDoublingException {
        Clubs newClub = null;
        if (isClubSaveOk(clubRepository.findAll(),
                clubRequest.getFC())) {
            newClub = clubRepository.save(clubConvertor.toRequest(clubRequest));
            }
        return  clubConvertor.toResponse(Objects.requireNonNull(newClub));

    }

//        Clubs newClub = clubRepository.save(clubConvertor.toRequest(clubRequest));
//        return clubConvertor.toResponse(newClub);



    @Override
    public Clubs findByRankingPlace(Long id) {
        return clubRepository.findById(id).orElseThrow
                (() -> new ClubNotFoundException
                        (String.format("Club with id %d not found", id.intValue())));
    }

    @Override
    @Transactional
    public ClubResponse updateClub(ClubUpdate clubUpdate) {
        Clubs club = clubRepository.findById(Long.parseUnsignedLong(clubUpdate.getId())).orElseThrow(() ->
                new ClubNotFoundException(String.format("Club with id %s not found", clubUpdate.getId())));
        club.setSPI(clubUpdate.getNewSPI());
        clubRepository.save(club);
        return clubConvertor.toResponse(club);
    }

    @Override
    public void deleteClub(Long id) {
        if (clubRepository.findById(id).isEmpty()) {
            throw new ClubNotFoundException(String.format("Club with id %d not found", id.intValue()));
        } else {
            clubRepository.deleteById(id);
        }
    }
}
