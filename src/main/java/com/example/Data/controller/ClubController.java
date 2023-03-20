package com.example.Data.controller;

import com.example.Data.convertor.ClubConvertor;
import com.example.Data.dto.ClubRequest;
import com.example.Data.dto.ClubResponse;
import com.example.Data.dto.ClubUpdate;
import com.example.Data.entity.Clubs;
import com.example.Data.impl.ClubServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clubs")
@RequiredArgsConstructor
public class ClubController {

    @Autowired
    private ClubServiceImpl clubService;

    @Autowired
    private ClubConvertor clubConvertor;

    @PostMapping(path = "/add")
    public ResponseEntity<ClubResponse> addClub (@RequestBody @Valid ClubRequest clubRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clubService.addClub(clubRequest));
    }

    @GetMapping("/get_club")
    public ResponseEntity<ClubResponse> findByRankingPlace(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(clubConvertor.toResponse(clubService.findByRankingPlace(id)));
    }

    @PutMapping("/update")
    public ResponseEntity<ClubResponse> updateClub (@RequestBody @Valid ClubUpdate clubUpdate) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(clubService.updateClub(clubUpdate));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete (@PathVariable Long id) {
        clubService.deleteClub(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Club has been successfully deleted");
    }



}
