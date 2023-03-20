package com.example.Data.impl;

import com.example.Data.convertor.ClubConvertor;
import com.example.Data.dto.ClubRequest;
import com.example.Data.dto.ClubResponse;
import com.example.Data.dto.ClubUpdate;
import com.example.Data.entity.Clubs;
import com.example.Data.exception.ClubNotFoundException;
import com.example.Data.repository.ClubRepository;
import com.example.Data.service.ClubService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;
    private final ClubConvertor convertor;

    public ClubServiceImpl (ClubRepository clubRepository, ClubConvertor convertor) {
        this.clubRepository = clubRepository;
        this.convertor = convertor;
    }


    @Override
    @Transactional
    public ClubResponse addClub(ClubRequest clubRequest) {
        Clubs newClub = clubRepository.save(convertor.toRequest(clubRequest));
        return convertor.toResponse(newClub);

    }

    @Override
    public Clubs findByRankingPlace(Long id) {
        return clubRepository.findById(id).orElseThrow
        (() -> new ClubNotFoundException
                (String.format("Club with id %d not found", id.intValue())));
    }

    @Override
    @Transactional
    public ClubResponse updateClub(ClubUpdate clubUpdate) {
        Clubs club = clubRepository.findById(Long.parseUnsignedLong(clubUpdate.getNewId())).orElseThrow(() ->
                new ClubNotFoundException(String.format("Club with id %s not found", clubUpdate.getNewId())));
        club.setSPI(Integer.valueOf(String.valueOf(clubUpdate.getNewSPI())));
        clubRepository.save(club);
        return convertor.toResponse(club);
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
