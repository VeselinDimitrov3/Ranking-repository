package com.example.Data.controller;

import com.example.Data.convertor.ClubConvertor;
import com.example.Data.convertor.NationalTeamConvertor;
import com.example.Data.dto.*;
import com.example.Data.impl.ClubServiceImpl;
import com.example.Data.impl.NationalTeamServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/nationalTeams")
@RequiredArgsConstructor
public class NationalTeamController {
    @Autowired
    private NationalTeamServiceImpl nationalTeamService;
    @Autowired
    private NationalTeamConvertor nationalTeamConvertor;


    @PostMapping(path = "/add")
    public ResponseEntity<NationalTeamResponse> addNationalTeam (@RequestBody @Valid NationalTeamRequest nationalTeamRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nationalTeamService.addNationalTeam(nationalTeamRequest));
    }

    @GetMapping("/get_nationalTeam")
    public ResponseEntity<NationalTeamResponse> findByRankingPlace (@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(nationalTeamConvertor.toResponse(nationalTeamService.findByRankingPlace(id)));
    }

    @PutMapping("/update")
    public ResponseEntity<NationalTeamResponse> updateNationalTeam (@RequestBody @Valid NationalTeamUpdate nationalTeamUpdate) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(nationalTeamService.updateNationalTeam(nationalTeamUpdate));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteNationalTeam (@PathVariable Long id) {
        nationalTeamService.deleteNationalTeam(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Club has been successfully deleted");

    }

}
