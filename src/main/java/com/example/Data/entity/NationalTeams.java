package com.example.Data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "national_teams")
public class NationalTeams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Clubs clubs;

    @Column
    private String team;

    @Column
    private String totalPoints;

    @Column
    private String previousPoints;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "nationalTeams")
    private List<Clubs> clubsList = new ArrayList<>();






}
