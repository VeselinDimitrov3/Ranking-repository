package com.example.Data.runner;

import com.example.Data.dto.ClubRequest;
import com.example.Data.dto.ClubResponse;
import com.example.Data.dto.NationalTeamRequest;
import com.example.Data.entity.Clubs;
import com.example.Data.entity.NationalTeams;
import com.example.Data.impl.ClubServiceImpl;
import com.example.Data.service.ClubService;
import com.example.Data.service.NationalTeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final ClubService clubService;
    private final NationalTeamService nationalTeamService;

    public Runner(ClubService clubService, NationalTeamService nationalTeamService) {
        this.clubService = clubService;
        this.nationalTeamService = nationalTeamService;
    }

    @Override
    public void run(String... args) throws Exception {

        ClubRequest club = new ClubRequest();
        club.setFC("Manchester City");
        club.setLeague("Premier League");
        club.setSPI("92.3");

        clubService.addClub(club);


        NationalTeamRequest nationalTeam = new NationalTeamRequest();
        nationalTeam.setTeam("Brazil");
        nationalTeam.setTotalPoints("1840.77");
        nationalTeam.setPreviousPoints("1841.3");

        nationalTeamService.addNationalTeam(nationalTeam);

    }
}
